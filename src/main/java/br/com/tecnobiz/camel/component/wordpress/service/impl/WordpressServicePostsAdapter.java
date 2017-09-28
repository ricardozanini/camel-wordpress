package br.com.tecnobiz.camel.component.wordpress.service.impl;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.tecnobiz.camel.component.wordpress.WordpressConstants;
import br.com.tecnobiz.camel.component.wordpress.api.PostsAPI;
import br.com.tecnobiz.camel.component.wordpress.model.Post;
import br.com.tecnobiz.camel.component.wordpress.model.Context;
import br.com.tecnobiz.camel.component.wordpress.model.PostSearchCriteria;
import br.com.tecnobiz.camel.component.wordpress.service.WordpressServicePosts;

/**
 * The {@link WordpressServicePosts} implementation. Aggregates the
 * {@link PostsAPI} interface using {@link JAXRSClientFactory} to make the API
 * calls.
 * 
 * @since 0.0.1
 */
public class WordpressServicePostsAdapter extends AbstractWordpressCrudServiceAdapter<PostsAPI, Post> implements WordpressServicePosts {

    private static final Logger LOGGER = LoggerFactory.getLogger(WordpressServicePostsAdapter.class);

    private PostsAPI api;

    public WordpressServicePostsAdapter(final String wordpressUrl) {
        super(wordpressUrl);
    }

    @Override
    protected Class<PostsAPI> getApiType() {
        return PostsAPI.class;
    }

    @Override
    protected PostsAPI getApi() {
        return this.api;
    }

    @Override
    protected void setApi(PostsAPI api) {
        this.api = api;
    }

    @Override
    public List<Post> list(PostSearchCriteria criteria) {
        LOGGER.debug("Calling list posts: searchCriteria {}", criteria);
        checkNotNull(criteria, "Please provide a search criteria");
        return api.list(WordpressConstants.API_VERSION, criteria.getContext(), criteria.getPage(), criteria.getPerPage(), criteria.getSearch(), criteria.getAfter(),
                        criteria.getAuthor(), criteria.getAuthorExclude(), criteria.getBefore(), criteria.getExclude(), criteria.getInclude(), criteria.getOffset(),
                        criteria.getOrder(), criteria.getOrderBy(), criteria.getSlug(), criteria.getStatus(), criteria.getCategories(), criteria.getCategoriesExclude(),
                        criteria.getTags(), criteria.getTagsExclude(), criteria.getStick());
    }

    @Override
    public Post retrievePost(int postId, Context context, String password) {
        LOGGER.debug("Calling retrievePosts: postId {};  postContext: {}", postId, context);
        checkArgument(postId > 0, "Please provide a non zero post id");
        checkNotNull(context, "Provide a post context");
        return api.retrieve(WordpressConstants.API_VERSION, postId, context, password);
    }

    @Override
    public Post retrievePost(int postId, Context context) {
        return this.retrievePost(postId, context, "");
    }

    @Override
    public Post retrievePost(int postId) {
        return this.retrievePost(postId, Context.view, "");
    }

}
