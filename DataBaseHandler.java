package tictactoe;

import java.sql.*;
import java.util.Vector;

public class DataBaseHandler {

    private Connection conn;
    private ResultSet res;

    public static void main(String[] args) {
        Vector<User> U = new Vector<User>();
        DataBaseHandler db = new DataBaseHandler();
        User u1 = db.new User();
        User u2 = db.new User();
        u1.id = 4;
        u2.id = 9;
        
        P_Positions PXpos = db.new P_Positions();
        P_Positions POpos = db.new P_Positions();
        PXpos.PID = 4;
        POpos.PID = 9;
        db.selectGameID(PXpos, POpos);
            
        db.selectPositions(PXpos);
        db.selectPositions(POpos);
       
        
        System.out.println(PXpos.POS1);
        System.out.println(PXpos.POS2);
        System.out.println(PXpos.POS3);
        System.out.println(PXpos.POS4);
        System.out.println("------------------------------------");
        System.out.println(POpos.POS1);
        System.out.println(POpos.POS2);
        System.out.println(POpos.POS3);
        System.out.println(POpos.POS4);

    }

    private void connectDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tic_tac_toe", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertUser(User s) {
        try {
            connectDB();
            String query = "Insert INTO User(Username, Password, Gender) VALUES(?,?,?);";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, s.Username);
            stmt.setString(2, s.password);
            stmt.setString(3, String.valueOf(s.gender));

            stmt.executeUpdate();

            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectUser(User s) {
        try {
            connectDB();

            String query = new String("SELECT * FROM User WHERE Username ='" + s.Username
                    + "' AND Password ='" + s.password + "'");

            Statement stmt = conn.createStatement();

            this.res = stmt.executeQuery(query);

            while (res.next()) {
                s.gender = res.getNString("Gender").charAt(0);
                s.id = res.getInt("UID");
                s.score = res.getInt("Score");
            }

            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void UsersData(Vector<User> Users) {
        try {
            connectDB();

            String query = new String("SELECT Username, Score FROM User;");
            Statement stmt = conn.createStatement();
            this.res = stmt.executeQuery(query);

            while (res.next()) {
                User u = new User();
                u.score = res.getInt("Score");
                u.Username = res.getString("Username");
                Users.add(u);
            }

            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertGame(User Player1, User Player2) {
        try {
            connectDB();
            String query = new String("Insert INTO Game(PXID, POID) VALUES(?,?);");
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Player1.id);
            stmt.setInt(2, Player2.id);
            stmt.executeUpdate();
            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectGameID(P_Positions Player1, P_Positions Player2) {
        try {
            connectDB();
            String query = new String("SELECT * FROM Game WHERE PXID ='" + Player1.PID
                    + "' AND POID ='" + Player2.PID + "';");
            Statement stmt = conn.createStatement();
            this.res = stmt.executeQuery(query);

            while (res.next()) {
                Player1.GID = res.getInt("GID");
                Player2.GID = Player1.GID;
            }

            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteGame(User Player1, User Player2) {
        try {
            connectDB();
            String query = new String("DELETE FROM Game WHERE PXID ='" + Player1.id
                    + "' AND POID ='" + Player2.id + "';");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPosition(P_Positions Ppos) {
        String query = new String("INSERT INTO P_Positions(GID ,PID , POS1 , POS2 , POS3 , POS4) "
                + "VALUES (?,?,?,?,?,?)");
        try {
            connectDB();
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1,Ppos.GID);
            stmt.setInt(2,Ppos.PID);
            stmt.setInt(3,Ppos.POS1);
            stmt.setInt(4,Ppos.POS2);
            stmt.setInt(5,Ppos.POS3);
            stmt.setInt(6,Ppos.POS4);
            stmt.executeUpdate();
            this.conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void updatePosions(P_Positions Ppos){
        String query = new String("UPDATE P_Positions SET POS1 = ?, POS2 = ?, POS3 = ?, POS4 = ? WHERE GID = ? AND PID = ?;");
        try{
            connectDB();
            
            PreparedStatement stmt = this.conn.prepareStatement(query);
            
            stmt.setInt(1, Ppos.POS1);
            stmt.setInt(2, Ppos.POS2);
            stmt.setInt(3, Ppos.POS3);
            stmt.setInt(4, Ppos.POS4);
            stmt.setInt(5, Ppos.GID);
            stmt.setInt(6, Ppos.PID);
            stmt.executeUpdate();
            this.conn.close();
        } catch( Exception e){
            e.printStackTrace();
        } 
    
    }

    public void selectPositions(P_Positions P_pos) {
        try {
            connectDB();
            String query = new String("SELECT * FROM P_Positions WHERE PID ='"
                    + P_pos.PID + "' AND GID = '" + P_pos.GID + "';");

            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while (res.next()) {
                P_pos.POS1 = res.getInt("POS1");
                P_pos.POS2 = res.getInt("POS2");
                P_pos.POS3 = res.getInt("POS3");
                P_pos.POS4 = res.getInt("POS4");
            }
            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class Game {

        public int GID;
        public int PXID;
        public int POID;
    }

    public class P_Positions {

        public int GID;
        public int PID;
        public int POS1;
        public int POS2;
        public int POS3;
        public int POS4;

    }

    public class User {

        int id;
        public String Username;
        public String password;
        public char gender;
        public int score;
    }

}
