package com.kevinheise.application;

import com.kevinheise.entity.Role;
import com.kevinheise.entity.User;
import com.kevinheise.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/userRole")
public class UserRole {
    @GET
    @Produces("text/html")
    public Response getUserAndRoles() {
        GenericDao userDao = new GenericDao(User.class);
        GenericDao roleDao = new GenericDao(Role.class);

        List<User> users = userDao.getAll();
        List<Role> roles = roleDao.getAll();

        String output = "<h1>User Table:</h1><br />";
        output += "<table><tr><th>Id</th><th>First Name</th><th>Role</th></tr>";

        for (int i = 0; i < users.size(); i++) {
            output += "<tr><td>" + users.get(i).getId() + "</td>";
            output += "<td>" + users.get(i).getFirstName() + "</td>";
            output += "<td>" + roles.get(i).getRoleName() + "</td></tr>";
        }

        output += "</table>";

        return Response.status(200).entity(output).build();
    }
}
