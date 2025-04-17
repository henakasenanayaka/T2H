package com.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    
    private static String url = "jdbc:mysql://localhost:3306/t2h";
    private static String u = "root";
    private static String pass = "";
    private static boolean isSuccess=false;
    
    public static boolean login(String email, String password){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM cus WHERE email='" + email + "' AND pwd='" + password + "' AND type='user'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static String getName(String email){
        String fname = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select fname from cus where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                fname = rs.getString("fname");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return fname;
    }
    
    public static List<Map<String, String>> getLanLon(String email) {
        List<Map<String, String>> LanLon = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select lat,lon from cus where email='" + email + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put("lat", rs.getString(1));
                userMap.put("lon", rs.getString(2));

                LanLon.add(userMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return LanLon;
    }
    
    public static boolean updateLatLon(String email, String lat, String lon){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update cus set lat='"+lat+"', lon='"+lon+"' where email='"+email+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> getstations(){
        List<Map<String, String>> stations = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select tsid,station from tstation";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> station = new HashMap<>();
                station.put("tsid", rs.getString(1));
                station.put("station", rs.getString(2));
                stations.add(station);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
}
    
    public static int getid(String email){
        int cid = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select cid from cus where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                cid = rs.getInt("cid");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cid;
    }
    
    public static boolean addorderdet(String weight,String ostatus,String reclat,String reclng,int cid,String recname,String recmobile, int fromstation, int tostation){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into corder(weight,date,time,ostatus,reclat,reclng,cid,recname,recmobile,tostation,fromstation) "
                    + "values('"+weight+"',CURDATE(),CURTIME(),'"+ostatus+"','"+reclat+"','"+reclng+"',"+cid+",'"+recname+"','"+recmobile+"','"+tostation+"','"+fromstation+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static String getanystation(int tsid){
        String station = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select station from tstation where tsid='"+tsid+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                station = rs.getString("station");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return station;
    }
    
    public static String cusmobile(String email){
        String mobile = "";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select mobile from cus where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                mobile = rs.getString("mobile");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return mobile;
    }
    
    public static List<Map<String, String>> getstationlatlon(int tsid) {
        List<Map<String, String>> LanLon = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select lat,lng from tstation where tsid='" + tsid + "'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> userMap = new HashMap<>();
                userMap.put("lat", rs.getString(1));
                userMap.put("lon", rs.getString(2));

                LanLon.add(userMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return LanLon;
    }
    
    public static List<Map<String, String>> getorderdet(int cid) {
        List<Map<String, String>> orderdet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.weight,a.fname,a.lname,a.mobile,b.recname,b.recmobile,c.station,d.station,a.lat,a.lon,b.reclat,b.reclng,c.lat,c.lng,d.lat,d.lng from cus a "
                    + "inner join corder b on a.cid=b.cid "
                    + "inner join tstation c on b.tostation=c.tsid "
                    + "inner join tstation d on b.fromstation=d.tsid "
                    + "where b.ostatus = 'placed' and a.cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> orderdetMap = new HashMap<>();
                orderdetMap.put("weight", rs.getString(1));
                orderdetMap.put("fname", rs.getString(2));
                orderdetMap.put("lname", rs.getString(3));
                orderdetMap.put("mobile", rs.getString(4));
                orderdetMap.put("recname", rs.getString(5));
                orderdetMap.put("recmobile", rs.getString(6));
                orderdetMap.put("tostation", rs.getString(7));
                orderdetMap.put("fromstation", rs.getString(8));
                orderdetMap.put("lat", rs.getString(9));
                orderdetMap.put("lon", rs.getString(10));
                orderdetMap.put("reclat", rs.getString(11));
                orderdetMap.put("reclon", rs.getString(12));
                orderdetMap.put("tolat", rs.getString(13));
                orderdetMap.put("tolon", rs.getString(14));
                orderdetMap.put("fromlat", rs.getString(15));
                orderdetMap.put("fromlon", rs.getString(16));

                orderdet.add(orderdetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderdet;
    }
    
    public static boolean register(String fname,String lname, String nic, String mobile, String email, String pwd){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into cus(fname,lname,nic,mobile,email,pwd,type) values('"+fname+"','"+lname+"','"+nic+"','"+mobile+"','"+email+"','"+pwd+"','user')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean CheckPlacedOrder(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select * from corder where cid='"+cid+"' and ostatus='placed'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean DelPlacedOrder(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "DELETE FROM corder WHERE cid='"+cid+"' AND ostatus='Placed'";
            int  rs = stmt.executeUpdate(sql);
            if(rs>0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean TrainAdminLogin(String email, String password){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM tadmin WHERE email='" + email + "' AND pwd='" + password + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static int getTadminID(String email){
        int tid = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select tid from tadmin where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                tid = rs.getInt("tid");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tid;
    }
    
    public static List<Map<String, String>> getTadminDet() {
        List<Map<String, String>> tadmindet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.tid,a.fname,a.lname,a.nic,a.mobile,a.email,a.pwd,b.station from tadmin a INNER join tstation b on a.tsid=b.tsid";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> tadmindetMap = new HashMap<>();
                tadmindetMap.put("tid", rs.getString(1));
                tadmindetMap.put("fname", rs.getString(2));
                tadmindetMap.put("lname", rs.getString(3));
                tadmindetMap.put("nic", rs.getString(4));
                tadmindetMap.put("mobile", rs.getString(5));
                tadmindetMap.put("email", rs.getString(6));
                tadmindetMap.put("pwd", rs.getString(7));
                tadmindetMap.put("station", rs.getString(8));

                tadmindet.add(tadmindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tadmindet;
    }
    
    public static boolean AdminLogin(String email, String password){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM cus WHERE email='" + email + "' AND pwd='" + password + "' AND type='admin'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> AdminEditTAdmin(int tid) {
        List<Map<String, String>> tadmindet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.tid,a.fname,a.lname,a.nic,a.mobile,a.email,a.pwd,b.station from tadmin a INNER join tstation b on a.tsid=b.tsid where a.tid='"+tid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> tadmindetMap = new HashMap<>();
                tadmindetMap.put("tid", rs.getString(1));
                tadmindetMap.put("fname", rs.getString(2));
                tadmindetMap.put("lname", rs.getString(3));
                tadmindetMap.put("nic", rs.getString(4));
                tadmindetMap.put("mobile", rs.getString(5));
                tadmindetMap.put("email", rs.getString(6));
                tadmindetMap.put("pwd", rs.getString(7));
                tadmindetMap.put("station", rs.getString(8));

                tadmindet.add(tadmindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tadmindet;
    }
    
    public static int getStationID(String station){
        int tsid = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select tsid from tstation where station='"+station+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                tsid = rs.getInt("tsid");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tsid;
    }
    
    public static boolean AdminUpdateTAdmin(int tid, String fname, String lname,String nic,String mobile,String email,String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update tadmin set fname='"+fname+"', lname='"+lname+"', nic='"+nic+"', mobile='"+mobile+"',email='"+email+"', pwd='"+pwd+"' where tid='"+tid+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean AdminDeleteTAdmin(int tid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Delete from tadmin where tid='"+tid+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> AdminGetAllUsers() {
        List<Map<String, String>> userdets = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from cus where type='user'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> userdetMap = new HashMap<>();
                userdetMap.put("cid", rs.getString(1));
                userdetMap.put("fname", rs.getString(2));
                userdetMap.put("lname", rs.getString(3));
                userdetMap.put("nic", rs.getString(4));
                userdetMap.put("mobile", rs.getString(5));
                userdetMap.put("email", rs.getString(7));
                userdetMap.put("pwd", rs.getString(8));

                userdets.add(userdetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userdets;
    }
    
    public static List<Map<String, String>> AdminEditUser(int cid) {
        List<Map<String, String>> edituserdets = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from cus where type='user' and cid = '"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> edituserdetMap = new HashMap<>();
                edituserdetMap.put("cid", rs.getString(1));
                edituserdetMap.put("fname", rs.getString(2));
                edituserdetMap.put("lname", rs.getString(3));
                edituserdetMap.put("nic", rs.getString(4));
                edituserdetMap.put("mobile", rs.getString(5));
                edituserdetMap.put("email", rs.getString(7));
                edituserdetMap.put("pwd", rs.getString(8));

                edituserdets.add(edituserdetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return edituserdets;
    }
    
    public static boolean AdminUpdateUser(int cid, String fname, String lname,String nic,String mobile,String email,String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update cus set fname='"+fname+"', lname='"+lname+"', nic='"+nic+"', mobile='"+mobile+"',email='"+email+"', pwd='"+pwd+"' where cid='"+cid+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> AdminGetAllAdmins() {
        List<Map<String, String>> admindets = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from cus where type='admin'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> admindetMap = new HashMap<>();
                admindetMap.put("cid", rs.getString(1));
                admindetMap.put("fname", rs.getString(2));
                admindetMap.put("lname", rs.getString(3));
                admindetMap.put("nic", rs.getString(4));
                admindetMap.put("mobile", rs.getString(5));
                admindetMap.put("email", rs.getString(7));
                admindetMap.put("pwd", rs.getString(8));

                admindets.add(admindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admindets;
    }
    
    public static List<Map<String, String>> AdminEditAdmin(int cid) {
        List<Map<String, String>> tadmindet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from cus where type='admin' and cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> tadmindetMap = new HashMap<>();
                tadmindetMap.put("cid", rs.getString(1));
                tadmindetMap.put("fname", rs.getString(2));
                tadmindetMap.put("lname", rs.getString(3));
                tadmindetMap.put("nic", rs.getString(4));
                tadmindetMap.put("mobile", rs.getString(5));
                tadmindetMap.put("email", rs.getString(7));
                tadmindetMap.put("pwd", rs.getString(8));

                tadmindet.add(tadmindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tadmindet;
    }
    
    public static boolean AdminUpdateAdmin(int cid, String fname, String lname,String nic,String mobile,String email,String pwd){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update cus set fname='"+fname+"', lname='"+lname+"', nic='"+nic+"', mobile='"+mobile+"',email='"+email+"', pwd='"+pwd+"' where cid='"+cid+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }else{
                isSuccess = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> AdminGetOngoingOrders() {
        List<Map<String, String>> ongoingordersdets = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.oid,a.date,a.time,a.amount,b.fname,b.lname,d.station,c.station from corder a inner join cus b on a.cid=b.cid inner join tstation c on a.tostation=c.tsid inner join tstation d on a.fromstation=d.tsid where a.ostatus IN ('Ongoing','Taken From Rider','Taken From Trainadmin','Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered')";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> ongoingordersdetMap = new HashMap<>();
                ongoingordersdetMap.put("oid", rs.getString(1));
                ongoingordersdetMap.put("date", rs.getString(2));
                ongoingordersdetMap.put("time", rs.getString(3));
                ongoingordersdetMap.put("amount", rs.getString(4));
                ongoingordersdetMap.put("fname", rs.getString(5));
                ongoingordersdetMap.put("lname", rs.getString(6));
                ongoingordersdetMap.put("fromstation", rs.getString(7));
                ongoingordersdetMap.put("tostation", rs.getString(8));

                ongoingordersdets.add(ongoingordersdetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ongoingordersdets;
    }
    
    public static List<Map<String, String>> AdminGetOngoingOrder(int oid) {
        List<Map<String, String>> tadmindet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.oid,b.fname,b.lname,b.email,b.lat,b.lon,a.weight,a.date,a.time,a.amount,a.reclat,a.reclng,a.recname,a.recmobile,d.station,c.station,b.cid,a.ostatus from corder a inner join cus b on a.cid=b.cid inner join tstation c on a.tostation=c.tsid inner join tstation d on a.fromstation=d.tsid where a.ostatus IN ('Ongoing','Taken From Rider','Taken From Trainadmin','Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered') and a.oid='"+oid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> tadmindetMap = new HashMap<>();
                tadmindetMap.put("oid", rs.getString(1));
                tadmindetMap.put("fname", rs.getString(2));
                tadmindetMap.put("lname", rs.getString(3));
                tadmindetMap.put("email", rs.getString(4));
                tadmindetMap.put("lat", rs.getString(5));
                tadmindetMap.put("lon", rs.getString(6));
                tadmindetMap.put("weight", rs.getString(7));
                tadmindetMap.put("date", rs.getString(8));
                tadmindetMap.put("time", rs.getString(9));
                tadmindetMap.put("amount", rs.getString(10));
                tadmindetMap.put("reclat", rs.getString(11));
                tadmindetMap.put("reclon", rs.getString(12));
                tadmindetMap.put("recname", rs.getString(13));
                tadmindetMap.put("recmobile", rs.getString(14));
                tadmindetMap.put("fromstation", rs.getString(15));
                tadmindetMap.put("tostation", rs.getString(16));
                tadmindetMap.put("cid", rs.getString(17));
                tadmindetMap.put("ostatus", rs.getString(18));

                tadmindet.add(tadmindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tadmindet;
    }
    
    public static boolean AdminEditOngoingOrder(int oid, int cid, String weight,String date,String time,String amount,String reclat,String reclon,String recname, String recmobile,String ostatus, int tostationid,int fromstationid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update corder set weight='"+weight+"',date='"+date+"',time='"+time+"',amount='"+amount+"',reclat='"+reclat+"',reclng='"+reclon+"',recname='"+recname+"',recmobile='"+recmobile+"',tostation='"+tostationid+"',fromstation='"+fromstationid+"',ostatus='"+ostatus+"' where oid='"+oid+"' and cid='"+cid+"'";
            //insert into 
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean AdminAddAdmin(String fname,String lname, String nic, String mobile, String email, String pwd){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into cus(fname,lname,nic,mobile,email,pwd,type) values('"+fname+"','"+lname+"','"+nic+"','"+mobile+"','"+email+"','"+pwd+"','admin')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean AdminRegTAdmin(String fname,String lname, String nic, String mobile, String email, String pwd, int tsid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into tadmin(fname,lname,nic,mobile,email,pwd,tsid) values('"+fname+"','"+lname+"','"+nic+"','"+mobile+"','"+email+"','"+pwd+"','"+tsid+"')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean updateplacedorder(int cid){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update corder set ostatus='Ongoing' where cid='"+cid+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean Checkiforderistrackable(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM corder WHERE cid = '" + cid +"' AND ostatus IN ('Ongoing', 'Taken From Rider', 'Taken From Trainadmin', 'Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered');";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> getnotbusydriverlatlngs() {
        List<Map<String, String>> driverlatlngs = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select did,lat,lng from driver where cstatus!='busy'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> driverlatlngMap = new HashMap<>();
                driverlatlngMap.put("did", rs.getString(1));
                driverlatlngMap.put("lat", rs.getString(2));
                driverlatlngMap.put("lng", rs.getString(3));

                driverlatlngs.add(driverlatlngMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverlatlngs;
    }
    
    public static List<Map<String, String>> getdriverdets(int did) {
        List<Map<String, String>> driverlatlngs = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select * from driver where did='"+did+"'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> driverlatlngMap = new HashMap<>();
                driverlatlngMap.put("did", rs.getString(1));
                driverlatlngMap.put("fname", rs.getString(2));
                driverlatlngMap.put("lname", rs.getString(3));
                driverlatlngMap.put("nic", rs.getString(4));
                driverlatlngMap.put("mobile", rs.getString(5));
                driverlatlngMap.put("v", rs.getString(6));
                driverlatlngMap.put("vid", rs.getString(7));
                driverlatlngMap.put("email", rs.getString(8));
                driverlatlngMap.put("pwd", rs.getString(9));
                driverlatlngMap.put("cstatus", rs.getString(10));
                driverlatlngMap.put("lat", rs.getString(11));
                driverlatlngMap.put("lng", rs.getString(12));

                driverlatlngs.add(driverlatlngMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driverlatlngs;
    }
    
    public static int customerongoingorderid(int cid){
        int oid = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select oid from corder where cid='"+cid+"' and ostatus='Ongoing'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                oid = rs.getInt("oid");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return oid;
    }
    
    public static boolean orderdriver(int oid, int did){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into orderdriver(oid,did,status,type,date,time) values('"+oid+"','"+did+"','Ongoing','Taking order to Train',CURDATE(), CURTIME())";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean driverbusystatus(int did){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "update driver set cstatus='busy' where did='"+did+"'";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean inserttoorderstationfrom(int oid,int tsid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into ordertstation values('"+oid+"','"+tsid+"','From Driver & To Train',CURDATE(),'Ongoing')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean inserttoorderstationto(int oid,int tsid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "insert into ordertstation values('"+oid+"','"+tsid+"','From Train & To Receiver',CURDATE(),'Ongoing')";
            int rs = stmt.executeUpdate(sql);
            
            if(rs > 0){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> acceptedplacedorder(int cid) {
        List<Map<String, String>> tadmindet = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select b.lat,b.lon,d.fname,d.lname,d.mobile,d.vid,d.lat,d.lng,c.status from corder a INNER join cus b on a.cid=b.cid inner join orderdriver c on a.oid=c.oid INNER join driver d on c.did=d.did where c.type='Taking order to Train' and a.ostatus='ongoing' and b.cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> tadmindetMap = new HashMap<>();
                tadmindetMap.put("cuslat", rs.getString(1));
                tadmindetMap.put("cuslon", rs.getString(2));
                tadmindetMap.put("dfname", rs.getString(3));
                tadmindetMap.put("dlname", rs.getString(4));
                tadmindetMap.put("dmobile", rs.getString(5));
                tadmindetMap.put("dvid", rs.getString(6));
                tadmindetMap.put("dlat", rs.getString(7));
                tadmindetMap.put("dlon", rs.getString(8));
                tadmindetMap.put("status", rs.getString(9));                

                tadmindet.add(tadmindetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tadmindet;
    }
    
    public static List<Map<String, String>> takenfromriderservlet(int cid) {
        List<Map<String, String>> latlons = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select c.lat,c.lng,d.lat,d.lng from corder a inner join orderdriver b on a.oid=b.oid inner join driver c on b.did=c.did inner join tstation d on a.fromstation=d.tsid where a.ostatus='Taken From Rider' and a.cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> latlonsMap = new HashMap<>();
                latlonsMap.put("dlat", rs.getString(1));
                latlonsMap.put("dlon", rs.getString(2));
                latlonsMap.put("tlat", rs.getString(3));
                latlonsMap.put("tlon", rs.getString(4));

                latlons.add(latlonsMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latlons;
    }
    
    public static boolean Checkifordertakenbyrider(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM corder WHERE cid = '" + cid +"' AND ostatus IN ('Taken From Rider', 'Taken From Trainadmin', 'Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered')";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static boolean Checkifordertakenbytadmin(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM corder WHERE cid = '" + cid +"' AND ostatus IN ('Taken From Trainadmin', 'Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered');";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> takenfromtadminservlet(int cid) {
        List<Map<String, String>> latlons = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select d.lat,d.lng from corder a inner join orderdriver b on a.oid=b.oid inner join driver c on b.did=c.did inner join tstation d on a.fromstation=d.tsid where a.ostatus='Taken From Trainadmin' and a.cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> latlonsMap = new HashMap<>();
                latlonsMap.put("tlat", rs.getString(1));
                latlonsMap.put("tlon", rs.getString(2));

                latlons.add(latlonsMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latlons;
    }
    
    public static boolean Checkifordertakenbyrectadmin(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM corder WHERE cid = '" + cid +"' AND ostatus IN ('Reached to Receiver TrainAdmin', 'Out for Delivery', 'Delivered')";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> takenfromrectadminservlet(int cid) {
        List<Map<String, String>> latlons = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select d.lat,d.lng from corder a inner join orderdriver b on a.oid=b.oid inner join driver c on b.did=c.did inner join tstation d on a.tostation=d.tsid where a.ostatus='Reached to Receiver TrainAdmin' and a.cid='"+cid+"'";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                Map<String, String> latlonsMap = new HashMap<>();
                latlonsMap.put("tlat", rs.getString(1));
                latlonsMap.put("tlon", rs.getString(2));

                latlons.add(latlonsMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return latlons;
    }
    
    public static boolean Checkifordertakenbydeliveryguy(int cid){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM corder WHERE cid = '" + cid +"' AND ostatus IN ('Out for Delivery', 'Delivered');";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                isSuccess = true;
            }
            else{
                isSuccess = false;
            }
            return isSuccess;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    
    public static List<Map<String, String>> AdminGetDeliveredOrders() {
        List<Map<String, String>> ongoingordersdets = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "select a.oid,a.date,a.time,a.amount,b.fname,b.lname,d.station,c.station from corder a inner join cus b on a.cid=b.cid inner join tstation c on a.tostation=c.tsid inner join tstation d on a.fromstation=d.tsid where a.ostatus IN ('Delivered')";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, String> ongoingordersdetMap = new HashMap<>();
                ongoingordersdetMap.put("oid", rs.getString(1));
                ongoingordersdetMap.put("date", rs.getString(2));
                ongoingordersdetMap.put("time", rs.getString(3));
                ongoingordersdetMap.put("amount", rs.getString(4));
                ongoingordersdetMap.put("fname", rs.getString(5));
                ongoingordersdetMap.put("lname", rs.getString(6));
                ongoingordersdetMap.put("fromstation", rs.getString(7));
                ongoingordersdetMap.put("tostation", rs.getString(8));

                ongoingordersdets.add(ongoingordersdetMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ongoingordersdets;
    }
    
    public static int gettadmintsid(String email){
        int tsid = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, u, pass);
            Statement stmt = con.createStatement();
            String sql = "Select tsid from tadmin where email='"+email+"'";
            ResultSet rs = stmt.executeQuery(sql);
                
            if(rs.next()){
                tsid = rs.getInt("tsid");
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return tsid;
    }
}
