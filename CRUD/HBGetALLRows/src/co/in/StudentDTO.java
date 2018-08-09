package co.in;

public class StudentDTO {

	
	private int rollno, physics, chemistry, maths;
	
	private String name;
	
	
	
	public int getRollno()
	{
		return rollno; 
	}
	
			public void setRollno(int rollno)
			{
				this.rollno=rollno;
			}
	
	
	public String getName()
	{
		return name;
	}
			
			public void setName(String name)
			{
				this.name=name;
			}
			
	
	public int getPhysics()
	{
		return physics;
	}

			public void setPhysics(int physics)
			{
				this.physics=physics;
			}
			

	public int getChemistry()
	{
		return chemistry;
	}
	
			public void setChemistry(int chemistry)
			{
				this.chemistry=chemistry;
			}
			
	public int getMaths()
	{
		return maths;
	}
			
			public void setMaths(int maths)
			{
				this.maths=maths;
			}

}



