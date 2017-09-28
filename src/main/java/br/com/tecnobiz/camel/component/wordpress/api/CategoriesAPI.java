package br.com.tecnobiz.camel.component.wordpress.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import br.com.tecnobiz.camel.component.wordpress.model.Category;
import br.com.tecnobiz.camel.component.wordpress.model.CategoryOrderBy;
import br.com.tecnobiz.camel.component.wordpress.model.Context;
import br.com.tecnobiz.camel.component.wordpress.model.Order;

/**
 * Describes the Categories Wordpress API
 * 
 * @see <a href=
 *      "https://developer.wordpress.org/rest-api/reference/categories/">Categories
 *      API Reference</a>
 * @since 0.0.1
 */
@Path("/")
public interface CategoriesAPI extends WordpressAPI<Category> {
    
    //@formatter:off
    @GET
    @Path("/v{apiVersion}/categories")
    @Produces(MediaType.APPLICATION_JSON)
    List<Category> list(@PathParam("apiVersion") String apiVersion,
                        @QueryParam("context") Context context,
                        @QueryParam("page") Integer page,
                        @QueryParam("per_page") Integer perPage,
                        @QueryParam("search") String search,
                        @QueryParam("exclude") List<Integer> exclude,
                        @QueryParam("include") List<Integer> include,
                        @QueryParam("order") Order order,
                        @QueryParam("orderby") CategoryOrderBy orderBy,
                        @QueryParam("hide_empty") Boolean hideEmpty,
                        @QueryParam("parent") Integer parent,
                        @QueryParam("post") Integer post,
                        @QueryParam("slug") String slug);

    @GET
    @Path("/v{apiVersion}/categories/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Category retrieve(@PathParam("apiVersion") String apiVersion,
                      @PathParam("id") int categoryId, 
                      @QueryParam("context") Context context);
    
    @POST
    @Path("/v{apiVersion}/categories/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Category create(@PathParam("apiVersion") String apiVersion, Category category);
    
    @POST
    @Path("/v{apiVersion}/categories/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Category update(@PathParam("apiVersion") String apiVersion, 
                    @PathParam("id") int categoryId,  
                    Category category);
    
    @DELETE
    @Path("/v{apiVersion}/categories/{id}")
    void delete(@PathParam("apiVersion") String apiVersion, 
                    @PathParam("id") int categoryId,
                    @QueryParam("force") boolean force);
       
}
