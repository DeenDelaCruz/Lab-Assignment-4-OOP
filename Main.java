import java.util.Scanner;

class Main {

    private static final int maxAttempts = 3;
    private static final String validPassword = "password";
    
    private int attempts;

    public Main() {
        this.attempts = 0;
    }

    public void login(String username, String password) throws InvalidPasswordException, MaxLoginAttemptsException {


        if(!password.equals(validPassword)) {
            attempts++;
            if(attempts >= maxAttempts) {
                throw new MaxLoginAttemptsException("Maximum number of login attempts reached.");
            }
            throw new InvalidPasswordException("Invalid password! ");
        }

        if(attempts >= maxAttempts) {
            throw new MaxLoginAttemptsException("Maximum number of login attempts reached.");
        }

        attempts = 0;
        System.out.println("Welcome, " +username+ ". You have logged in succesfully.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Main auth = new Main();

        while(true) {
            try {

                System.out.print("Enter your credentials to log in. \nUsername: ");
                String username = input.nextLine();

                System.out.print("Password: ");
                String password = input.nextLine();

                auth.login(username, password);
                break;
            } catch (MaxLoginAttemptsException e) {
                System.out.println(e.getMessage());
                break;
            } catch (InvalidPasswordException e) {
                 System.out.println(e.getMessage()  + "Please try again.\n");
            }                 
        }
    }
}
