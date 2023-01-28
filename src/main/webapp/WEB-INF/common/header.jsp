<header>
 <nav class="navbar navbar-expand-md navbar-dark"
  style="background-color: #2596be;">
  <div>
   <a href="<%= request.getContextPath() %>/home" class="navbar-brand"> HTML Tips</a>
  </div>

  <ul class="navbar-nav navbar-collapse justify-content-end">
  <%if(session.getAttribute("userId")!=null){ %>
	<li><a href="<%= request.getContextPath() %>/admin/logout" class="nav-link">Logout</a></li>
	<li><a href="<%= request.getContextPath() %>/tips/create" class="nav-link">Create Tip</a></li>
	<%}else{ %>
   	<li><a href="<%= request.getContextPath() %>/admin" class="nav-link">Admin</a></li>
   	<%} %>
  </ul>
 </nav>
</header>