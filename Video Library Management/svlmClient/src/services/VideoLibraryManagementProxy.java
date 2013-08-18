package services;

public class VideoLibraryManagementProxy implements services.VideoLibraryManagement {
  private String _endpoint = null;
  private services.VideoLibraryManagement videoLibraryManagement = null;
  
  public VideoLibraryManagementProxy() {
    _initVideoLibraryManagementProxy();
  }
  
  public VideoLibraryManagementProxy(String endpoint) {
    _endpoint = endpoint;
    _initVideoLibraryManagementProxy();
  }
  
  private void _initVideoLibraryManagementProxy() {
    try {
      videoLibraryManagement = (new services.VideoLibraryManagementServiceLocator()).getVideoLibraryManagement();
      if (videoLibraryManagement != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)videoLibraryManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)videoLibraryManagement)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (videoLibraryManagement != null)
      ((javax.xml.rpc.Stub)videoLibraryManagement)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public services.VideoLibraryManagement getVideoLibraryManagement() {
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement;
  }
  
  public java.lang.String[] movieProfile(java.lang.String movid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.movieProfile(movid);
  }
  
  public java.lang.String delmember(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.delmember(memberid);
  }
  
  public java.lang.String createMovies(java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String reldate, int mcopies) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.createMovies(moviename, moviebanner, category, reldate, mcopies);
  }
  
  public java.lang.String[] rentMovie(java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.rentMovie(memberid, movieorder, date);
  }
  
  public java.lang.String payment(java.lang.String memberid, java.lang.String amount, java.lang.String paydate) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.payment(memberid, amount, paydate);
  }
  
  public java.lang.String[] pMembers() throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.pMembers();
  }
  
  public java.lang.String returnMovie(java.lang.String memberid, java.lang.String movieid, java.lang.String moviename, java.lang.String count, java.lang.String date, java.lang.String tid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.returnMovie(memberid, movieid, moviename, count, date, tid);
  }
  
  public java.lang.String[] sMembers() throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.sMembers();
  }
  
  public java.lang.String[] allMovies() throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.allMovies();
  }
  
  public java.lang.String[] allPersons() throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.allPersons();
  }
  
  public java.lang.String updatePinfo(java.lang.String fname, java.lang.String lname, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String country) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.updatePinfo(fname, lname, address, city, state, zipcode, memberid, country);
  }
  
  public java.lang.String[] searchMovie(java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String reldate) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.searchMovie(moviename, moviebanner, category, reldate);
  }
  
  public java.lang.String[] searchPerson(java.lang.String fname, java.lang.String lname, java.lang.String mtype, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String country) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.searchPerson(fname, lname, mtype, address, city, state, zipcode, memberid, country);
  }
  
  public java.lang.String movieCount(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.movieCount(memberid);
  }
  
  public java.lang.String movieDetails(java.lang.String movieid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.movieDetails(movieid);
  }
  
  public java.lang.String delMovies(java.lang.String movieid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.delMovies(movieid);
  }
  
  public java.lang.String updateMinfo(java.lang.String movieid, java.lang.String moviename, java.lang.String moviebanner, java.lang.String category, java.lang.String releasedate, java.lang.String mcopies) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.updateMinfo(movieid, moviename, moviebanner, category, releasedate, mcopies);
  }
  
  public java.lang.String personDetail(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.personDetail(memberid);
  }
  
  public java.lang.String movieName(java.lang.String movid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.movieName(movid);
  }
  
  public java.lang.String movieIssue(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.movieIssue(memberid);
  }
  
  public java.lang.String signIn(java.lang.String username, java.lang.String password) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.signIn(username, password);
  }
  
  public java.lang.String premiumtableupdation(java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.premiumtableupdation(memberid, movieorder, date);
  }
  
  public java.lang.String simpletableupdation(java.lang.String cardnum, java.lang.String cvv, java.lang.String memberid, java.lang.String[] movieorder, java.lang.String date) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.simpletableupdation(cardnum, cvv, memberid, movieorder, date);
  }
  
  public java.lang.String[] personDetails(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.personDetails(memberid);
  }
  
  public java.lang.String returnmovofmember(java.lang.String memberid) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.returnmovofmember(memberid);
  }
  
  public java.lang.String updateLoggedInfo(java.lang.String username, java.lang.String finallogintime) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.updateLoggedInfo(username, finallogintime);
  }
  
  public java.lang.String createMembers(java.lang.String fname, java.lang.String lname, java.lang.String mtype, java.lang.String address, java.lang.String city, java.lang.String state, java.lang.String zipcode, java.lang.String memberid, java.lang.String mdate, java.lang.String country, java.lang.String email, java.lang.String password, java.lang.String logintime) throws java.rmi.RemoteException{
    if (videoLibraryManagement == null)
      _initVideoLibraryManagementProxy();
    return videoLibraryManagement.createMembers(fname, lname, mtype, address, city, state, zipcode, memberid, mdate, country, email, password, logintime);
  }
  
  
}