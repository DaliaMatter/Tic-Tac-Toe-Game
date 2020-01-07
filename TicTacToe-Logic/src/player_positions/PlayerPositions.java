package player_positions;

public class PlayerPositions {

	private String player;
	private int[] positions;
	private char type; // Symbol

	public PlayerPositions() {
		player = "";
		positions = new int[4];
		for (int i = 0; i < 4; i++) {
			positions[i] = -1;
		}
		type = 'E';
	}

	public PlayerPositions(String name, int[] pos, char symbol) {
		player = name;
		for (int i = 0; i < 4; i++) {
			positions[i] = pos[i];
		}
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

	public int[] getPositions() {
		return positions;
	}

	public void setPositions(int[] pos) {
		for (int i = 0; i < 4; i++) {
			positions[i] = pos[i];
		}
	}
}
