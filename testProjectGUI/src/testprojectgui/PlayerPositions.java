package testprojectgui;

public class PlayerPositions {

	private String player;
	private char type; // Symbol
        public int pos1;
        public int pos2;
        public int pos3;
        public int pos4;
        
	public PlayerPositions() {
		player = "";
		pos1 = -1;
                pos2 = -1;
                pos3 = -1;
                pos4 = -1;
		type = 'E';
	}

	public PlayerPositions(String name, int pos1, int pos2, int pos3, int pos4, char symbol) {
		player = name;
                this.pos1 = pos1;
                this.pos2 = pos2;
                this.pos3 = pos3;
                this.pos4 = pos4;
		type = symbol;
	}

	public char getType() {
		return type;
	}

	public void setType(char Type) {
		this.type = Type;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String name) {
		this.player = name;
	}
}
