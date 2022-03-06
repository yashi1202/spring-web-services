#RESTful Web Services
Social Media Applications

Social Media Application
SSN - Social Security Number
##Users -> Posts
Relationship between users and posts is one to many.

-Retrieve all users - GET /users
-Create a user -      POST /users
-Retrieve one user -  GET /users/{id} -> /users/1
-Delete a user  -     DELETE /users/{id} -> /users/1

retrieve all posts for a user - GET /users/{id}/posts
create a posts for a user -     POST /users/{id}/posts
retrieve details of a post -    GET /users/{id}/posts/{post_id} 

##Questions to Answer
What is dispatcher servlet?
Dispatcher servlet is handling all the requests. Whenever we type hello-world-bean into the browser, the request would go to Dispatcher servlet. Dispatcher servlet would be the one which would be handling the request first.
- Mapping servlet: 'dispatcherServlet' to[/] -> This is known as front controller for spring web      MVC framework.
When we are typing URI in the browser, we are sending a get request.
What does dispatcher servlet do?
Who is configuring dispatcher servlet?
Spring Boot Auto Configuration.
How does the HelloWorldBean object get converted to JSON?
because of Spring Boot Auto Configuration because the message converters and the Jackson beans are getting initialized.
Who is configuring the error mapping?
Spring Boot Auto Configuration


@ResponseBody - it is in RestController. When we put responseBody on a controller, the response from that would be mapped by a message converter into some other format.(Message converter used -> Jackson).
Jackson will convert HelloWorldBean to JSON and sends the response back.
The HelloWorldBean request goes to a dispatcher servlet, dispatcher servlet finds the HelloWorldController, the specific method HelloWorldBean. It calls it, gets the bean, invoke the conversion on it, converts it into JSON and returns the response back. 

Jackson to Object Mapper - conversion from JSON to beans and beans to JSON.
#User DAO

We will need this in order to manage the user.(Talking to the database and getting the details back).
@Repository annotation talks to database.
But right now, in UserDao service we are using a simple arraylist to store the list of users.
