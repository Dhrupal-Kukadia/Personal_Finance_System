package org.finance.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.finance.dto.TxAdditionDTO;
import org.finance.model.Transaction;
import org.finance.model.User;
import org.finance.repository.UserRepository;
import org.finance.service.PasswordService;
import org.finance.service.TransactionService;

import java.util.List;

@Path("/transactions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TransactionResource {
    @Inject
    TransactionService transactionService;
    @Inject
    PasswordService passwordService;
    @Inject
    UserRepository userRepository;

    @POST
    @Path("/insert")
    public void createTransaction(@QueryParam("userId") String userId, @QueryParam("password") String password, @RequestBody TxAdditionDTO TxDTO) {
        authenticateUser(userId, password);
        Transaction transaction = TxDTO.createTransactionFromDTO();
        transactionService.createTransaction(transaction);
    }

    @GET
    @Path("/{id}")
    public Transaction findTransactionById(@QueryParam("userId") String userId, @QueryParam("password") String password, @PathParam("id") String id) {
        authenticateUser(userId, password);
        return transactionService.findById(id);
    }

    @GET
    @Path("/all")
    public List<Transaction> findAllTransactions(@QueryParam("userId") String userId, @QueryParam("password") String password) {
        authenticateUser(userId, password);
        return transactionService.findAll(userId);
    }

    private void authenticateUser(String userId, String password) {
        User user = userRepository.findById(new ObjectId(userId));
        if(!passwordService.matchPassword(password, user.getPassword())) {
            throw new RuntimeException("Authentication failed: entered password is incorrect.");
        }
    }
}
