/**
 * 
 * Courese
 * @author Qinka qinka@live.com 李约瀚 14130140331
 * @license GPL3
 * @version 0.1.0.20
 *
 */

class Course
{
    private String _name;
    public String getName()
    {
	return _name;
    }
    public void setName(String name)
    {
	_name = name;
    }

    public Course(String name)
    {
	_name = name;
    }


    public static void main(String[] args)
    {
	if (args.length < 1)
	    {
		System.out.println("Usage: student_id {class}");
		System.exit(1);
	    }
	Student stu = new Student("",args[0]);
	if (args.length > 1)
	    {
		for (int i = 1;i<args.length;i++)
		    {
			stu.addCourse(new Course(args[i]));
		    }
	    }
	System.out.println(stu);
    }
}
