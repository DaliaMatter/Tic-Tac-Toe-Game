
/*
 * This class have all information that will use when user log in
 */

package userspk;

public class User {
	private char symbol;
	private char gender;
	private String userName;
	private String password;
	private static int score;

	public User() {
		symbol = 'E';
		gender = 'N';
		userName = "";
		password = "";
		score = -1;
	}

	public User(char symb, String user, char gender, String pass, int points) {
		this.symbol = symb;
		this.userName = user;
		this.gender = gender;
		this.password = pass;
		this.score = points;
	}

	public char getSymbol() {
		return symbol;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public void setSymbol(char symb) {
		symbol = symb;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		userName = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		password = pass;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int points) {
		score = points;
	}

}
