/**
 * VideoLibraryManagement.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package services;

public interface VideoLibraryManagement extends java.rmi.Remote {
    public java.lang.String[] movieProfile(java.lang.String movid) throws java.rmi.RemoteException;
    public java.lang.String delmember(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String createMovies(java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String reldate, int mcopies) throws java.rmi.RemoteException;
    public java.lang.String[] rentMovie(java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String payment(java.lang.String memberid, java.lang.String amount, java.lang.String paydate) throws java.rmi.RemoteException;
    public java.lang.String[] pMembers() throws java.rmi.RemoteException;
    public java.lang.String returnMovie(java.lang.String memberid, java.lang.String movieid, java.lang.String moviename, java.lang.String count, java.lang.String date, java.lang.String tid) throws java.rmi.RemoteException;
    public java.lang.String[] sMembers() throws java.rmi.RemoteException;
    public java.lang.String[] allMovies() throws java.rmi.RemoteException;
    public java.lang.String[] allPersons() throws java.rmi.RemoteException;
    public java.lang.String updatePinfo(java.lang.String fname, java.lang.String lname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String country) throws java.rmi.RemoteException;
    public java.lang.String[] searchMovie(java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String reldate) throws java.rmi.RemoteException;
    public java.lang.String[] searchPerson(java.lang.String fname, java.lang.String lname, java.lang.String mtype, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String country) throws java.rmi.RemoteException;
    public java.lang.String movieCount(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String movieDetails(java.lang.String movieid) throws java.rmi.RemoteException;
    public java.lang.String delMovies(java.lang.String movieid) throws java.rmi.RemoteException;
    public java.lang.String updateMinfo(java.lang.String movieid, java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String releasedate, java.lang.String mcopies) throws java.rmi.RemoteException;
    public java.lang.String personDetail(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String movieName(java.lang.String movid) throws java.rmi.RemoteException;
    public java.lang.String movieIssue(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException;
    public java.lang.String premiumtableupdation(java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String simpletableupdation(java.lang.String cardnum, java.lang.String cvv, java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String[] personDetails(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String returnmovofmember(java.lang.String memberid) throws java.rmi.RemoteException;
    public java.lang.String updateLoggedInfo(java.lang.String username, java.lang.String finallogintime) throws java.rmi.RemoteException;
    public java.lang.String createMembers(java.lang.String fname, java.lang.String lname, java.lang.String mtype, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String mdate, java.lang.String country, java.lang.String email, java.lang.String password, java.lang.String logintime) throws java.rmi.RemoteException;
}
