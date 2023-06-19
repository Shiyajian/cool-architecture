package com.github.shiyajian.cool.support.services.cases;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author shiyajian
 * create: 2023-04-03
 */
@Component
public class CaseManager implements InitializingBean {

    @Autowired
    private List<CaseTemplate<?>> caseTemplates;

    private static final Map<String, CaseTemplate<?>> CASE_CACHE = Maps.newConcurrentMap();

    @SuppressWarnings("unchecked")
    public static <T extends CaseTemplate<C>, C extends Context> C execute(Class<T> caseTemplateClass, C context) {
        CaseTemplate<C> caseTemplate = (CaseTemplate<C>) CASE_CACHE.get(caseTemplateClass.getName());
        return caseTemplate.execute(context);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        caseTemplates.forEach(e -> {
            CASE_CACHE.put(e.getClass().getName(), e);
        });
    }
}
