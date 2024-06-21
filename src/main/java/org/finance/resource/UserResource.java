package org.finance.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.finance.dto.UserAdditionDTO;
import org.finance.model.User;
import org.finance.service.PasswordService;
import org.finance.service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {
    @Inject
    UserService userService;
    @Inject
    PasswordService passwordService;

    @GET
    @Path("/{id}")
    public User getUser(@PathParam("id") String id) {
        return userService.findById(id);
    }

    @GET
    @Path("/name/{name}")
    public User getUserByName(@PathParam("name") String name) {
        return userService.findByName(name);
    }

    @POST
    @Path("/create")
    public void createUser(@RequestBody UserAdditionDTO userAdditionDTO) {
        User user = userAdditionDTO.createUserFromDTO();
        user.setPassword(passwordService.encodePassword(user.getPassword()));
        userService.createUser(user);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") String id) {
        userService.deleteUser(id);
    }
}
