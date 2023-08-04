import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		System.out.println("welcome");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) 
		{
			System.out.println("Press 1 to ADD student");
			System.out.println("press 2 to Delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 to exit app");
			int choice=Integer.parseInt(br.readLine());
			
			if(choice==1) {
				// ADD student
				System.out.println("Enter user name:");
				String name = br.readLine();
				
				System.out.println("Enter user phone:");
				String phone=br.readLine();
				
				System.out.println("Enter user city");
				String city=br.readLine();
				
				//create student object to store student
				Student st = new Student(name , phone ,city);
				boolean ans =StudentDao.insertStudentToDb(st);
				if(ans) {
					System.out.println("student added");
				}else {
					System.out.println("unsuccessfull");
				}
				System.out.println(st);
				
			}else if(choice==2) {
				// delete student
				System.out.println("enter student id to delete");
				int userId =Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("student deleted");
				}else {
					System.out.println("unsuccessfull");
				}
				
			}else if(choice==3) {
				//display student
				StudentDao.showAllStudents();
			}else if(choice==4) {
				//exit
				break;
			}else {
				
			}
		}

	}

}
