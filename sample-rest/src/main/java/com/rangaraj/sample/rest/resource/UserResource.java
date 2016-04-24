
package com.rangaraj.sample.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.rangaraj.sample.rest.model.CreateUserRequest;
import com.rangaraj.sample.rest.model.CreateUserResponse;
import com.rangaraj.sample.rest.resource.support.ResponseWrapper;

@Path("user")
public interface UserResource {


    /**
     * For creating new user in the system
     * 
     * @param entity
     *     
     */
    @POST
    @Consumes("application/json")
    @Produces({
        "application/json"
    })
    UserResource.PostUserResponse postUser(CreateUserRequest entity)
        throws Exception
    ;

    public class PostUserResponse
        extends ResponseWrapper
    {


        private PostUserResponse(Response delegate) {
            super(delegate);
        }

        /**
         * 
         * @param entity
         *     
         */
        public static UserResource.PostUserResponse withJsonOK(CreateUserResponse entity) {
            Response.ResponseBuilder responseBuilder = Response.status(200).header("Content-Type", "application/json");
            responseBuilder.entity(entity);
            return new UserResource.PostUserResponse(responseBuilder.build());
        }

    }

}
