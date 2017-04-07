\begin{code}
module Main where

import Data.Aeson
import Data.Time
import Yesod.Core
import Yesod.Core.Json
import Yesod.Persist
import Database.Persist
import Database.Persist.Postgresql
import Database.Persist.TH
import System.Environment
import Control.Monad.Logger (runStderrLoggingT)
import Control.Monad.Trans.Resource (runResourceT)
import Control.Monad.Trans.Reader

import Data.Text(Text)
import qualified Data.Text as T
import qualified Data.ByteString.Char8 as BC8


share [mkPersist sqlSettings, mkMigrate "migrateAll"] [persistLowerCase|
Todo json
  date Day
  context Text
  owner Text
  deriving Show Eq
Note json
  context Text
  owner Text
  deriving Show Eq
Appointment json
  date Day
  context Text
  owner Text
  deriving Show Eq
Contact json
  fname Text
  lname Text
  email Text
  owner Text
  deriving Show Eq
|]


data App = App
           { dbPool :: ConnectionPool
           }


mkYesod "App" [parseRoutes|
/list             ListR              GET
/list/todo        ListTodoR          GET
/list/note        ListNoteR          GET
/list/appointment ListAppointmentR   GET
/list/contact     ListContactR       GET

/add              AddR               POST
|]

instance Yesod App
instance YesodPersist App where
  type YesodPersistBackend App = SqlBackend
  runDB a = getYesod >>= (runSqlPool a . dbPool)

getListR :: Handler Value
getListR = undefined
  
getListTodoR :: Handler Value
getListTodoR = do
  own <- lookupGetParam "own"
  let own' = case own of
        Nothing -> []
        Just o' -> [ TodoOwner ==. o']
  begin <- lookupGetParam "begin"
  end   <- lookupGetParam "end"
  let limit = case (begin,end) of
        (Just b,Just e) -> let b' = read $ T.unpack b
                               e' = read $ T.unpack e
                           in [ TodoDate >. b'
                              , TodoDate <. e'
                              ]
        _ -> []
  items <- fmap (map (\(Entity _ item) -> item)) $ runDB $ selectList (own' ++ limit) []
  returnJson $ object ["status" .= (0::Int), "context" .= items]


getListNoteR :: Handler Value
getListNoteR = do
  own <- lookupGetParam "own"
  let own' = case own of
        Nothing -> []
        Just o' -> [ NoteOwner ==. o']
  items <- fmap (map (\(Entity _ item) -> item)) $ runDB $ selectList own'  []
  returnJson $ object ["status" .= (0::Int), "context" .= items]

getListAppointmentR :: Handler Value
getListAppointmentR = do
  own <- lookupGetParam "own"
  let own' = case own of
        Nothing -> []
        Just o' -> [ AppointmentOwner ==. o']
  begin <- lookupGetParam "begin"
  end   <- lookupGetParam "end"
  let limit = case (begin,end) of
        (Just b,Just e) -> let b' = read $ T.unpack b
                               e' = read $ T.unpack e
                           in [ AppointmentDate >. b'
                              , AppointmentDate <. e'
                              ]
        _ -> []
  items <- fmap (map (\(Entity _ item) -> item)) $ runDB $ selectList (own' ++ limit) []
  returnJson $ object ["status" .= (0::Int), "context" .= items]

getListContactR :: Handler Value
getListContactR = do
  own <- lookupGetParam "own"
  let own' = case own of
        Nothing -> []
        Just o' -> [ TodoOwner ==. o']
  items <- fmap (map (\(Entity _ item) -> item)) $ runDB $ selectList own' []
  returnJson $ object ["status" .= (0::Int), "context" .= items]

postAddR :: Handler T.Text
postAddR = undefined



main :: IO ()
main = do
  now <- getCurrentTime
  args <- unwords <$> getArgs
  runStderrLoggingT $ withPostgresqlPool (BC8.pack args) 100 $ \pool -> liftIO $ do
    runResourceT $ flip runSqlPool pool $ do
      runMigration migrateAll
      insert $ Todo (utctDay now) "abc" "qinka"
    warp 3000 $ App pool


\end{code}
