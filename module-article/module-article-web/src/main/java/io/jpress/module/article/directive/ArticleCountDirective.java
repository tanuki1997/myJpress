package io.jpress.module.article.directive;

import com.jfinal.aop.Inject;
import com.jfinal.template.Env;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import io.jboot.web.directive.annotation.JFinalDirective;
import io.jboot.web.directive.base.JbootDirectiveBase;
import io.jpress.module.article.service.ArticleCommentService;
import io.jpress.module.article.service.ArticleService;

@JFinalDirective("articleCount")
public class ArticleCountDirective extends JbootDirectiveBase {
    @Inject
    private ArticleService service;
    @Inject
    private ArticleCommentService articleCommentService;
    @Override
    public void onRender(Env env, Scope scope, Writer writer) {
        Long articleViewCount=service.articleCountDirective();

        Integer articleCount=service.articleCount();
        Integer commentCount=articleCommentService.commentCount();
        scope.setLocal("articleViewCount", articleViewCount);
        scope.setLocal("articleCount", articleCount);
        scope.setLocal("commentCount", commentCount);
        renderBody(env, scope, writer);
    }
    @Override
    public boolean hasEnd() {
        return true;
    }
}
