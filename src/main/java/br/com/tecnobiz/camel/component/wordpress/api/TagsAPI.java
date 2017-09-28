package br.com.tecnobiz.camel.component.wordpress.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.tecnobiz.camel.component.wordpress.model.Context;
import br.com.tecnobiz.camel.component.wordpress.model.Order;
import br.com.tecnobiz.camel.component.wordpress.model.Tag;
import br.com.tecnobiz.camel.component.wordpress.model.TagOrderBy;

/**
 * Describes the Tags Wordpress API
 * 
 * @see <a href= "https://developer.wordpress.org/rest-api/reference/tags/">Tags
 *      API Reference</a>
 * @since 0.0.1
 */
@Path("/")
public interface TagsAPI extends WordpressAPI<Tag> {

    //@formatter:off
    @GET
    @Path("/v{apiVersion}/tags")
    @Produces(MediaType.APPLICATION_JSON)
    List<Tag> list(@PathParam("apiVersion") String apiVersion,
                        @QueryParam("context") Context context,
                        @QueryParam("page") Integer page,
                        @QueryParam("per_page") Integer perPage,
                        @QueryParam("search") String search,
                        @QueryParam("exclude") List<Integer> exclude,
                        @QueryParam("include") List<Integer> include,
                        @QueryParam("offset") List<Integer> offset,
                        @QueryParam("order") Order order,
                        @QueryParam("orderby") TagOrderBy orderBy,
                        @QueryParam("hide_empty") Boolean hideEmpty,
                        @QueryParam("post") Integer post,
                        @QueryParam("slug") String slug);
    @GET
    @Path("/v{apiVersion}/tags/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Tag retrieve(@PathParam("apiVersion") String apiVersion,
                 @PathParam("id") Integer id,
                 @QueryParam("context") Context context);
    
    @POST
    @Path("/v{apiVersion}/tags")
    Tag create(@PathParam("apiVersion") String apiVersion,
               Tag tag);
    
    @POST
    @Path("/v{apiVersion}/tags/{id}")
    Tag update(@PathParam("apiVersion") String apiVersion,
               @PathParam("id") Integer id,
               Tag tag);
    
    @DELETE
    @Path("/v{apiVersion}/tags/{id}")
    void delete(@PathParam("apiVersion") String apiVersion,
               @PathParam("id") Integer id,
               @QueryParam("force") boolean force);
}
