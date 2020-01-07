package tictactoe;

import java.sql.*;

public class DataBaseHandler {
    private Connection conn;
    private ResultSet res;
    
    private void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");            
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tic_tac_toe", "root","");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
            
    public void insertUser(User s ){
        try {
            connectDB();
            String query = "Insert INTO User(Username, Password, Fullname, Gender) VALUES(?,?,?, ?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            stmt.setString(1, s.Username);
            stmt.setString(2, s.password);
            stmt.setString(3, s.Fullname);
            stmt.setString(4, String.valueOf(s.gender) );
            
            stmt.executeUpdate();
            
            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void selectUser( User s ){
        try {            
            connectDB();
            
            String query = "SELECT * FROM User WHERE Username ='";
            query = query.concat(s.Username + "';");
            Statement stmt = conn.createStatement();
            
            this.res = stmt.executeQuery(query);
            
            while(res.next()){
                s.Fullname = res.getNString("Fullname");
                s.gender = res.getNString("Gender").charAt(0);
                s.id = res.getInt("UID");
                s.score = res.getInt("Score");
            }
            
            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void insertGame(Game g){
        try {
            connectDB();
            String query = "Insert INTO Game(PXID, POID) VALUES(?,?);";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, g.PXID);
            stmt.setInt(2, g.POID);
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void selectGame(Game g){
        try {            
            connectDB();
            String query = "SELECT * FROM Game WHERE GID ='";
            query = query.concat(g.GID + "';");
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery(query);
            
            while(res.next()){
                g.PXID = res.getInt("PXID");
                g.POID = res.getInt("POID");
            }
            
            this.conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteGame(Game g){
        try{
            connectDB();
            String query = new String ("DELETE FROM Game WHERE GID ='" + g.GID +"';");
            Statement stmt = conn.createStatement();
            stmt.executeQuery(query);
            this.conn.close();
        }catch( Exception e){
            e.printStackTrace();
        }
    }
   
    public void selectOPositions(P_Positions P_pos){
        try {            
            connectDB();
            String query = new String ("SELECT * FROM P_Positions, Game WHERE `P_Positions`.`PID` ='" + 
                        P_pos.PID + "' AND `Game`.`GID` = '" + P_pos.GID + 
                        "' AND `P_Positions`.`PID` = `Game`.`POID` "+ 
                        "AND `P_Positions`.`GID` = `Game`.`GID`");
            
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while(res.next()){
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
    
        public void selectXPositions(P_Positions P_pos){
        try {            
            connectDB();
            String query = new String ("SELECT * FROM P_Positions, Game WHERE `P_Positions`.`PID` ='" + 
                        P_pos.PID + "' AND `Game`.`GID` = '" + P_pos.GID + 
                        "' AND `P_Positions`.`PID` = `Game`.`PXID` "+ 
                        "AND `P_Positions`.`GID` = `Game`.`GID`");
            
            Statement stmt = conn.createStatement();
            res = stmt.executeQuery(query);
            while(res.next()){
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
    
    public class Game{
        public int GID;
        public int PXID;
        public int POID;
    }
    
    public class P_Positions{
        public int GID;
        public int PID;
        public int POS1;
        public int POS2;
        public int POS3;
        public int POS4;
        
    }
    
    public class User{
        int id;
        public String Username;
        public String Fullname;
        public String password;
        public char gender;
        public int score;
    }
            
}
