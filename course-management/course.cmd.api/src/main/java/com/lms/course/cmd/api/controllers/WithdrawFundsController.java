package com.lms.course.cmd.api.controllers;

import com.lms.course.cmd.api.commands.RemoveCourseCommand;
import com.lms.course.core.dto.BaseResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/withdrawFunds")
public class WithdrawFundsController {
    private final CommandGateway commandGateway;

    @Autowired
    public WithdrawFundsController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PutMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('WRITE_PRIVILEGE')")
    public ResponseEntity<BaseResponse> withdrawFunds(@PathVariable(value = "id") String id,
                                                      @Valid @RequestBody RemoveCourseCommand command) {
        try {
            command.setId(id);
            commandGateway.send(command).get();

            return new ResponseEntity<>(new BaseResponse("Withdrawal successfully completed!"), HttpStatus.OK);
        } catch (Exception e) {
            var safeErrorMessage = "Error while processing request to withdraw funds from bank account for id - " + id;
            System.out.println(e.toString());

            return new ResponseEntity<>(new BaseResponse(safeErrorMessage), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
