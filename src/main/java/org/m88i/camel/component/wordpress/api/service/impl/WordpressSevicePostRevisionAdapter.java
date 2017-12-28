package org.m88i.camel.component.wordpress.api.service.impl;

import static com.google.common.base.Preconditions.checkArgument;

import java.util.List;

import org.m88i.camel.component.wordpress.api.model.Context;
import org.m88i.camel.component.wordpress.api.model.PostRevision;
import org.m88i.camel.component.wordpress.api.service.WordpressServicePostRevision;
import org.m88i.camel.component.wordpress.api.service.spi.PostRevisionsAPI;

public class WordpressSevicePostRevisionAdapter extends AbstractWordpressServiceAdapter<PostRevisionsAPI> implements WordpressServicePostRevision {

    public WordpressSevicePostRevisionAdapter(final String wordpressUrl, final String apiVersion) {
        super(wordpressUrl, apiVersion);
    }

    @Override
    protected Class<PostRevisionsAPI> getApiType() {
        return PostRevisionsAPI.class;
    }

    @Override
    public void delete(Integer postId, Integer revisionId) {
        checkArgument(postId > 0, "Please define a post id");
        checkArgument(revisionId > 0, "Please define a revision id");
        this.getApi().delete(this.getApiVersion(), postId, revisionId);
    }

    @Override
    public PostRevision retrieve(Integer postId, Integer revisionId, Context context) {
        checkArgument(postId > 0, "Please define a post id");
        checkArgument(revisionId > 0, "Please define a revision id");
        return this.getApi().retrieveRevision(this.getApiVersion(), postId, revisionId, context);
    }

    @Override
    public List<PostRevision> list(Integer postId, Context context) {
        checkArgument(postId > 0, "Please define a post id");
        return this.getApi().list(this.getApiVersion(), postId, context);
    }

}
