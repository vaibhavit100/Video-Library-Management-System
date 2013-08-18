<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleVideoLibraryManagementProxyid" scope="session" class="services.VideoLibraryManagementProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleVideoLibraryManagementProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleVideoLibraryManagementProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleVideoLibraryManagementProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        services.VideoLibraryManagement getVideoLibraryManagement10mtemp = sampleVideoLibraryManagementProxyid.getVideoLibraryManagement();
if(getVideoLibraryManagement10mtemp == null){
%>
<%=getVideoLibraryManagement10mtemp %>
<%
}else{
        if(getVideoLibraryManagement10mtemp!= null){
        String tempreturnp11 = getVideoLibraryManagement10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String movid_1id=  request.getParameter("movid16");
            java.lang.String movid_1idTemp = null;
        if(!movid_1id.equals("")){
         movid_1idTemp  = movid_1id;
        }
        java.lang.String[] movieProfile13mtemp = sampleVideoLibraryManagementProxyid.movieProfile(movid_1idTemp);
if(movieProfile13mtemp == null){
%>
<%=movieProfile13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(movieProfile13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(movieProfile13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 18:
        gotMethod = true;
        String memberid_2id=  request.getParameter("memberid21");
            java.lang.String memberid_2idTemp = null;
        if(!memberid_2id.equals("")){
         memberid_2idTemp  = memberid_2id;
        }
        java.lang.String delmember18mtemp = sampleVideoLibraryManagementProxyid.delmember(memberid_2idTemp);
if(delmember18mtemp == null){
%>
<%=delmember18mtemp %>
<%
}else{
        String tempResultreturnp19 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(delmember18mtemp));
        %>
        <%= tempResultreturnp19 %>
        <%
}
break;
case 23:
        gotMethod = true;
        String moviename_3id=  request.getParameter("moviename26");
            java.lang.String moviename_3idTemp = null;
        if(!moviename_3id.equals("")){
         moviename_3idTemp  = moviename_3id;
        }
        String moviebanner_4id=  request.getParameter("moviebanner28");
            java.lang.String moviebanner_4idTemp = null;
        if(!moviebanner_4id.equals("")){
         moviebanner_4idTemp  = moviebanner_4id;
        }
        String category_5id=  request.getParameter("category30");
            java.lang.String category_5idTemp = null;
        if(!category_5id.equals("")){
         category_5idTemp  = category_5id;
        }
        String reldate_6id=  request.getParameter("reldate32");
            java.lang.String reldate_6idTemp = null;
        if(!reldate_6id.equals("")){
         reldate_6idTemp  = reldate_6id;
        }
        String mcopies_7id=  request.getParameter("mcopies34");
        int mcopies_7idTemp  = Integer.parseInt(mcopies_7id);
        java.lang.String createMovies23mtemp = sampleVideoLibraryManagementProxyid.createMovies(moviename_3idTemp,moviebanner_4idTemp,category_5idTemp,reldate_6idTemp,mcopies_7idTemp);
if(createMovies23mtemp == null){
%>
<%=createMovies23mtemp %>
<%
}else{
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createMovies23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
}
break;
case 36:
        gotMethod = true;
        String memberid_8id=  request.getParameter("memberid39");
            java.lang.String memberid_8idTemp = null;
        if(!memberid_8id.equals("")){
         memberid_8idTemp  = memberid_8id;
        }
        String amount_9id=  request.getParameter("amount41");
            java.lang.String amount_9idTemp = null;
        if(!amount_9id.equals("")){
         amount_9idTemp  = amount_9id;
        }
        String paydate_10id=  request.getParameter("paydate43");
            java.lang.String paydate_10idTemp = null;
        if(!paydate_10id.equals("")){
         paydate_10idTemp  = paydate_10id;
        }
        java.lang.String payment36mtemp = sampleVideoLibraryManagementProxyid.payment(memberid_8idTemp,amount_9idTemp,paydate_10idTemp);
if(payment36mtemp == null){
%>
<%=payment36mtemp %>
<%
}else{
        String tempResultreturnp37 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(payment36mtemp));
        %>
        <%= tempResultreturnp37 %>
        <%
}
break;
case 45:
        gotMethod = true;
        java.lang.String[] pMembers45mtemp = sampleVideoLibraryManagementProxyid.pMembers();
if(pMembers45mtemp == null){
%>
<%=pMembers45mtemp %>
<%
}else{
        String tempreturnp46 = null;
        if(pMembers45mtemp != null){
        java.util.List listreturnp46= java.util.Arrays.asList(pMembers45mtemp);
        tempreturnp46 = listreturnp46.toString();
        }
        %>
        <%=tempreturnp46%>
        <%
}
break;
case 48:
        gotMethod = true;
        String memberid_11id=  request.getParameter("memberid51");
            java.lang.String memberid_11idTemp = null;
        if(!memberid_11id.equals("")){
         memberid_11idTemp  = memberid_11id;
        }
        String movieid_12id=  request.getParameter("movieid53");
            java.lang.String movieid_12idTemp = null;
        if(!movieid_12id.equals("")){
         movieid_12idTemp  = movieid_12id;
        }
        String moviename_13id=  request.getParameter("moviename55");
            java.lang.String moviename_13idTemp = null;
        if(!moviename_13id.equals("")){
         moviename_13idTemp  = moviename_13id;
        }
        String count_14id=  request.getParameter("count57");
            java.lang.String count_14idTemp = null;
        if(!count_14id.equals("")){
         count_14idTemp  = count_14id;
        }
        String date_15id=  request.getParameter("date59");
            java.lang.String date_15idTemp = null;
        if(!date_15id.equals("")){
         date_15idTemp  = date_15id;
        }
        String tid_16id=  request.getParameter("tid61");
            java.lang.String tid_16idTemp = null;
        if(!tid_16id.equals("")){
         tid_16idTemp  = tid_16id;
        }
        java.lang.String returnMovie48mtemp = sampleVideoLibraryManagementProxyid.returnMovie(memberid_11idTemp,movieid_12idTemp,moviename_13idTemp,count_14idTemp,date_15idTemp,tid_16idTemp);
if(returnMovie48mtemp == null){
%>
<%=returnMovie48mtemp %>
<%
}else{
        String tempResultreturnp49 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(returnMovie48mtemp));
        %>
        <%= tempResultreturnp49 %>
        <%
}
break;
case 63:
        gotMethod = true;
        java.lang.String[] sMembers63mtemp = sampleVideoLibraryManagementProxyid.sMembers();
if(sMembers63mtemp == null){
%>
<%=sMembers63mtemp %>
<%
}else{
        String tempreturnp64 = null;
        if(sMembers63mtemp != null){
        java.util.List listreturnp64= java.util.Arrays.asList(sMembers63mtemp);
        tempreturnp64 = listreturnp64.toString();
        }
        %>
        <%=tempreturnp64%>
        <%
}
break;
case 66:
        gotMethod = true;
        java.lang.String[] allMovies66mtemp = sampleVideoLibraryManagementProxyid.allMovies();
if(allMovies66mtemp == null){
%>
<%=allMovies66mtemp %>
<%
}else{
        String tempreturnp67 = null;
        if(allMovies66mtemp != null){
        java.util.List listreturnp67= java.util.Arrays.asList(allMovies66mtemp);
        tempreturnp67 = listreturnp67.toString();
        }
        %>
        <%=tempreturnp67%>
        <%
}
break;
case 69:
        gotMethod = true;
        java.lang.String[] allPersons69mtemp = sampleVideoLibraryManagementProxyid.allPersons();
if(allPersons69mtemp == null){
%>
<%=allPersons69mtemp %>
<%
}else{
        String tempreturnp70 = null;
        if(allPersons69mtemp != null){
        java.util.List listreturnp70= java.util.Arrays.asList(allPersons69mtemp);
        tempreturnp70 = listreturnp70.toString();
        }
        %>
        <%=tempreturnp70%>
        <%
}
break;
case 72:
        gotMethod = true;
        String fname_17id=  request.getParameter("fname75");
            java.lang.String fname_17idTemp = null;
        if(!fname_17id.equals("")){
         fname_17idTemp  = fname_17id;
        }
        String lname_18id=  request.getParameter("lname77");
            java.lang.String lname_18idTemp = null;
        if(!lname_18id.equals("")){
         lname_18idTemp  = lname_18id;
        }
        String address_19id=  request.getParameter("address79");
            java.lang.String address_19idTemp = null;
        if(!address_19id.equals("")){
         address_19idTemp  = address_19id;
        }
        String city_20id=  request.getParameter("city81");
            java.lang.String city_20idTemp = null;
        if(!city_20id.equals("")){
         city_20idTemp  = city_20id;
        }
        String state_21id=  request.getParameter("state83");
            java.lang.String state_21idTemp = null;
        if(!state_21id.equals("")){
         state_21idTemp  = state_21id;
        }
        String zipcode_22id=  request.getParameter("zipcode85");
            java.lang.String zipcode_22idTemp = null;
        if(!zipcode_22id.equals("")){
         zipcode_22idTemp  = zipcode_22id;
        }
        String memberid_23id=  request.getParameter("memberid87");
            java.lang.String memberid_23idTemp = null;
        if(!memberid_23id.equals("")){
         memberid_23idTemp  = memberid_23id;
        }
        String country_24id=  request.getParameter("country89");
            java.lang.String country_24idTemp = null;
        if(!country_24id.equals("")){
         country_24idTemp  = country_24id;
        }
        java.lang.String updatePinfo72mtemp = sampleVideoLibraryManagementProxyid.updatePinfo(fname_17idTemp,lname_18idTemp,address_19idTemp,city_20idTemp,state_21idTemp,zipcode_22idTemp,memberid_23idTemp,country_24idTemp);
if(updatePinfo72mtemp == null){
%>
<%=updatePinfo72mtemp %>
<%
}else{
        String tempResultreturnp73 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updatePinfo72mtemp));
        %>
        <%= tempResultreturnp73 %>
        <%
}
break;
case 91:
        gotMethod = true;
        String moviename_25id=  request.getParameter("moviename94");
            java.lang.String moviename_25idTemp = null;
        if(!moviename_25id.equals("")){
         moviename_25idTemp  = moviename_25id;
        }
        String moviebanner_26id=  request.getParameter("moviebanner96");
            java.lang.String moviebanner_26idTemp = null;
        if(!moviebanner_26id.equals("")){
         moviebanner_26idTemp  = moviebanner_26id;
        }
        String category_27id=  request.getParameter("category98");
            java.lang.String category_27idTemp = null;
        if(!category_27id.equals("")){
         category_27idTemp  = category_27id;
        }
        String reldate_28id=  request.getParameter("reldate100");
            java.lang.String reldate_28idTemp = null;
        if(!reldate_28id.equals("")){
         reldate_28idTemp  = reldate_28id;
        }
        java.lang.String[] searchMovie91mtemp = sampleVideoLibraryManagementProxyid.searchMovie(moviename_25idTemp,moviebanner_26idTemp,category_27idTemp,reldate_28idTemp);
if(searchMovie91mtemp == null){
%>
<%=searchMovie91mtemp %>
<%
}else{
        String tempreturnp92 = null;
        if(searchMovie91mtemp != null){
        java.util.List listreturnp92= java.util.Arrays.asList(searchMovie91mtemp);
        tempreturnp92 = listreturnp92.toString();
        }
        %>
        <%=tempreturnp92%>
        <%
}
break;
case 102:
        gotMethod = true;
        String fname_29id=  request.getParameter("fname105");
            java.lang.String fname_29idTemp = null;
        if(!fname_29id.equals("")){
         fname_29idTemp  = fname_29id;
        }
        String lname_30id=  request.getParameter("lname107");
            java.lang.String lname_30idTemp = null;
        if(!lname_30id.equals("")){
         lname_30idTemp  = lname_30id;
        }
        String mtype_31id=  request.getParameter("mtype109");
            java.lang.String mtype_31idTemp = null;
        if(!mtype_31id.equals("")){
         mtype_31idTemp  = mtype_31id;
        }
        String address_32id=  request.getParameter("address111");
            java.lang.String address_32idTemp = null;
        if(!address_32id.equals("")){
         address_32idTemp  = address_32id;
        }
        String city_33id=  request.getParameter("city113");
            java.lang.String city_33idTemp = null;
        if(!city_33id.equals("")){
         city_33idTemp  = city_33id;
        }
        String state_34id=  request.getParameter("state115");
            java.lang.String state_34idTemp = null;
        if(!state_34id.equals("")){
         state_34idTemp  = state_34id;
        }
        String zipcode_35id=  request.getParameter("zipcode117");
            java.lang.String zipcode_35idTemp = null;
        if(!zipcode_35id.equals("")){
         zipcode_35idTemp  = zipcode_35id;
        }
        String memberid_36id=  request.getParameter("memberid119");
            java.lang.String memberid_36idTemp = null;
        if(!memberid_36id.equals("")){
         memberid_36idTemp  = memberid_36id;
        }
        String country_37id=  request.getParameter("country121");
            java.lang.String country_37idTemp = null;
        if(!country_37id.equals("")){
         country_37idTemp  = country_37id;
        }
        java.lang.String[] searchPerson102mtemp = sampleVideoLibraryManagementProxyid.searchPerson(fname_29idTemp,lname_30idTemp,mtype_31idTemp,address_32idTemp,city_33idTemp,state_34idTemp,zipcode_35idTemp,memberid_36idTemp,country_37idTemp);
if(searchPerson102mtemp == null){
%>
<%=searchPerson102mtemp %>
<%
}else{
        String tempreturnp103 = null;
        if(searchPerson102mtemp != null){
        java.util.List listreturnp103= java.util.Arrays.asList(searchPerson102mtemp);
        tempreturnp103 = listreturnp103.toString();
        }
        %>
        <%=tempreturnp103%>
        <%
}
break;
case 123:
        gotMethod = true;
        String memberid_38id=  request.getParameter("memberid126");
            java.lang.String memberid_38idTemp = null;
        if(!memberid_38id.equals("")){
         memberid_38idTemp  = memberid_38id;
        }
        java.lang.String movieCount123mtemp = sampleVideoLibraryManagementProxyid.movieCount(memberid_38idTemp);
if(movieCount123mtemp == null){
%>
<%=movieCount123mtemp %>
<%
}else{
        String tempResultreturnp124 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(movieCount123mtemp));
        %>
        <%= tempResultreturnp124 %>
        <%
}
break;
case 128:
        gotMethod = true;
        String movieid_39id=  request.getParameter("movieid131");
            java.lang.String movieid_39idTemp = null;
        if(!movieid_39id.equals("")){
         movieid_39idTemp  = movieid_39id;
        }
        java.lang.String movieDetails128mtemp = sampleVideoLibraryManagementProxyid.movieDetails(movieid_39idTemp);
if(movieDetails128mtemp == null){
%>
<%=movieDetails128mtemp %>
<%
}else{
        String tempResultreturnp129 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(movieDetails128mtemp));
        %>
        <%= tempResultreturnp129 %>
        <%
}
break;
case 133:
        gotMethod = true;
        String movieid_40id=  request.getParameter("movieid136");
            java.lang.String movieid_40idTemp = null;
        if(!movieid_40id.equals("")){
         movieid_40idTemp  = movieid_40id;
        }
        java.lang.String delMovies133mtemp = sampleVideoLibraryManagementProxyid.delMovies(movieid_40idTemp);
if(delMovies133mtemp == null){
%>
<%=delMovies133mtemp %>
<%
}else{
        String tempResultreturnp134 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(delMovies133mtemp));
        %>
        <%= tempResultreturnp134 %>
        <%
}
break;
case 138:
        gotMethod = true;
        String movieid_41id=  request.getParameter("movieid141");
            java.lang.String movieid_41idTemp = null;
        if(!movieid_41id.equals("")){
         movieid_41idTemp  = movieid_41id;
        }
        String moviename_42id=  request.getParameter("moviename143");
            java.lang.String moviename_42idTemp = null;
        if(!moviename_42id.equals("")){
         moviename_42idTemp  = moviename_42id;
        }
        String moviebanner_43id=  request.getParameter("moviebanner145");
            java.lang.String moviebanner_43idTemp = null;
        if(!moviebanner_43id.equals("")){
         moviebanner_43idTemp  = moviebanner_43id;
        }
        String category_44id=  request.getParameter("category147");
            java.lang.String category_44idTemp = null;
        if(!category_44id.equals("")){
         category_44idTemp  = category_44id;
        }
        String releasedate_45id=  request.getParameter("releasedate149");
            java.lang.String releasedate_45idTemp = null;
        if(!releasedate_45id.equals("")){
         releasedate_45idTemp  = releasedate_45id;
        }
        String mcopies_46id=  request.getParameter("mcopies151");
            java.lang.String mcopies_46idTemp = null;
        if(!mcopies_46id.equals("")){
         mcopies_46idTemp  = mcopies_46id;
        }
        java.lang.String updateMinfo138mtemp = sampleVideoLibraryManagementProxyid.updateMinfo(movieid_41idTemp,moviename_42idTemp,moviebanner_43idTemp,category_44idTemp,releasedate_45idTemp,mcopies_46idTemp);
if(updateMinfo138mtemp == null){
%>
<%=updateMinfo138mtemp %>
<%
}else{
        String tempResultreturnp139 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateMinfo138mtemp));
        %>
        <%= tempResultreturnp139 %>
        <%
}
break;
case 153:
        gotMethod = true;
        String memberid_47id=  request.getParameter("memberid156");
            java.lang.String memberid_47idTemp = null;
        if(!memberid_47id.equals("")){
         memberid_47idTemp  = memberid_47id;
        }
        java.lang.String personDetail153mtemp = sampleVideoLibraryManagementProxyid.personDetail(memberid_47idTemp);
if(personDetail153mtemp == null){
%>
<%=personDetail153mtemp %>
<%
}else{
        String tempResultreturnp154 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(personDetail153mtemp));
        %>
        <%= tempResultreturnp154 %>
        <%
}
break;
case 158:
        gotMethod = true;
        String movid_48id=  request.getParameter("movid161");
            java.lang.String movid_48idTemp = null;
        if(!movid_48id.equals("")){
         movid_48idTemp  = movid_48id;
        }
        java.lang.String movieName158mtemp = sampleVideoLibraryManagementProxyid.movieName(movid_48idTemp);
if(movieName158mtemp == null){
%>
<%=movieName158mtemp %>
<%
}else{
        String tempResultreturnp159 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(movieName158mtemp));
        %>
        <%= tempResultreturnp159 %>
        <%
}
break;
case 163:
        gotMethod = true;
        String memberid_49id=  request.getParameter("memberid166");
            java.lang.String memberid_49idTemp = null;
        if(!memberid_49id.equals("")){
         memberid_49idTemp  = memberid_49id;
        }
        java.lang.String movieIssue163mtemp = sampleVideoLibraryManagementProxyid.movieIssue(memberid_49idTemp);
if(movieIssue163mtemp == null){
%>
<%=movieIssue163mtemp %>
<%
}else{
        String tempResultreturnp164 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(movieIssue163mtemp));
        %>
        <%= tempResultreturnp164 %>
        <%
}
break;
case 168:
        gotMethod = true;
        String username_50id=  request.getParameter("username171");
            java.lang.String username_50idTemp = null;
        if(!username_50id.equals("")){
         username_50idTemp  = username_50id;
        }
        String password_51id=  request.getParameter("password173");
            java.lang.String password_51idTemp = null;
        if(!password_51id.equals("")){
         password_51idTemp  = password_51id;
        }
        java.lang.String signIn168mtemp = sampleVideoLibraryManagementProxyid.signIn(username_50idTemp,password_51idTemp);
if(signIn168mtemp == null){
%>
<%=signIn168mtemp %>
<%
}else{
        String tempResultreturnp169 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(signIn168mtemp));
        %>
        <%= tempResultreturnp169 %>
        <%
}
break;
case 175:
        gotMethod = true;
        String memberid_52id=  request.getParameter("memberid178");
            java.lang.String memberid_52idTemp = null;
        if(!memberid_52id.equals("")){
         memberid_52idTemp  = memberid_52id;
        }
        java.lang.String[] personDetails175mtemp = sampleVideoLibraryManagementProxyid.personDetails(memberid_52idTemp);
if(personDetails175mtemp == null){
%>
<%=personDetails175mtemp %>
<%
}else{
        String tempreturnp176 = null;
        if(personDetails175mtemp != null){
        java.util.List listreturnp176= java.util.Arrays.asList(personDetails175mtemp);
        tempreturnp176 = listreturnp176.toString();
        }
        %>
        <%=tempreturnp176%>
        <%
}
break;
case 180:
        gotMethod = true;
        String memberid_53id=  request.getParameter("memberid183");
            java.lang.String memberid_53idTemp = null;
        if(!memberid_53id.equals("")){
         memberid_53idTemp  = memberid_53id;
        }
        java.lang.String returnmovofmember180mtemp = sampleVideoLibraryManagementProxyid.returnmovofmember(memberid_53idTemp);
if(returnmovofmember180mtemp == null){
%>
<%=returnmovofmember180mtemp %>
<%
}else{
        String tempResultreturnp181 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(returnmovofmember180mtemp));
        %>
        <%= tempResultreturnp181 %>
        <%
}
break;
case 185:
        gotMethod = true;
        String username_54id=  request.getParameter("username188");
            java.lang.String username_54idTemp = null;
        if(!username_54id.equals("")){
         username_54idTemp  = username_54id;
        }
        String finallogintime_55id=  request.getParameter("finallogintime190");
            java.lang.String finallogintime_55idTemp = null;
        if(!finallogintime_55id.equals("")){
         finallogintime_55idTemp  = finallogintime_55id;
        }
        java.lang.String updateLoggedInfo185mtemp = sampleVideoLibraryManagementProxyid.updateLoggedInfo(username_54idTemp,finallogintime_55idTemp);
if(updateLoggedInfo185mtemp == null){
%>
<%=updateLoggedInfo185mtemp %>
<%
}else{
        String tempResultreturnp186 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(updateLoggedInfo185mtemp));
        %>
        <%= tempResultreturnp186 %>
        <%
}
break;
case 192:
        gotMethod = true;
        String fname_56id=  request.getParameter("fname195");
            java.lang.String fname_56idTemp = null;
        if(!fname_56id.equals("")){
         fname_56idTemp  = fname_56id;
        }
        String lname_57id=  request.getParameter("lname197");
            java.lang.String lname_57idTemp = null;
        if(!lname_57id.equals("")){
         lname_57idTemp  = lname_57id;
        }
        String mtype_58id=  request.getParameter("mtype199");
            java.lang.String mtype_58idTemp = null;
        if(!mtype_58id.equals("")){
         mtype_58idTemp  = mtype_58id;
        }
        String address_59id=  request.getParameter("address201");
            java.lang.String address_59idTemp = null;
        if(!address_59id.equals("")){
         address_59idTemp  = address_59id;
        }
        String city_60id=  request.getParameter("city203");
            java.lang.String city_60idTemp = null;
        if(!city_60id.equals("")){
         city_60idTemp  = city_60id;
        }
        String state_61id=  request.getParameter("state205");
            java.lang.String state_61idTemp = null;
        if(!state_61id.equals("")){
         state_61idTemp  = state_61id;
        }
        String zipcode_62id=  request.getParameter("zipcode207");
            java.lang.String zipcode_62idTemp = null;
        if(!zipcode_62id.equals("")){
         zipcode_62idTemp  = zipcode_62id;
        }
        String memberid_63id=  request.getParameter("memberid209");
            java.lang.String memberid_63idTemp = null;
        if(!memberid_63id.equals("")){
         memberid_63idTemp  = memberid_63id;
        }
        String mdate_64id=  request.getParameter("mdate211");
            java.lang.String mdate_64idTemp = null;
        if(!mdate_64id.equals("")){
         mdate_64idTemp  = mdate_64id;
        }
        String country_65id=  request.getParameter("country213");
            java.lang.String country_65idTemp = null;
        if(!country_65id.equals("")){
         country_65idTemp  = country_65id;
        }
        String email_66id=  request.getParameter("email215");
            java.lang.String email_66idTemp = null;
        if(!email_66id.equals("")){
         email_66idTemp  = email_66id;
        }
        String password_67id=  request.getParameter("password217");
            java.lang.String password_67idTemp = null;
        if(!password_67id.equals("")){
         password_67idTemp  = password_67id;
        }
        String logintime_68id=  request.getParameter("logintime219");
            java.lang.String logintime_68idTemp = null;
        if(!logintime_68id.equals("")){
         logintime_68idTemp  = logintime_68id;
        }
        java.lang.String createMembers192mtemp = sampleVideoLibraryManagementProxyid.createMembers(fname_56idTemp,lname_57idTemp,mtype_58idTemp,address_59idTemp,city_60idTemp,state_61idTemp,zipcode_62idTemp,memberid_63idTemp,mdate_64idTemp,country_65idTemp,email_66idTemp,password_67idTemp,logintime_68idTemp);
if(createMembers192mtemp == null){
%>
<%=createMembers192mtemp %>
<%
}else{
        String tempResultreturnp193 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(createMembers192mtemp));
        %>
        <%= tempResultreturnp193 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>