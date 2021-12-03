package firstWebForm;
import io.javalin.Javalin;

public class Driver {
	
	static Person[] persons;
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex = 0;
		persons = new Person[10];
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/myfirstwebform", ctx -> {
			Person person = new Person();
			person.gender = ctx.formParam("gender");
			person.transportation = ctx.formParam("transportation");
			person.firstName = ctx.formParam("FirstName");
			person.lastName = ctx.formParam("LastName");
			person.email = ctx.formParam("Email");
			
			
			persons[currentIndex] = person;
			currentIndex++;
			
			String responseText = "";
			
			for(Person eachPerson : persons) {
				System.out.println(eachPerson);
				if(eachPerson != null) {
					responseText += eachPerson.gender + "<br>";
				}
				
			}
			
			
			
		});
		
	}
}
