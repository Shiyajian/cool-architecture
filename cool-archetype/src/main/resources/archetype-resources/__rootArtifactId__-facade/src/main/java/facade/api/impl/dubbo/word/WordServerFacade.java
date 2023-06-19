package ${package};
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import github.shiyajian.${rootArtifactId}.domain.repository.word.WordRepository;
import github.shiyajian.${rootArtifactId}.application.service.WordApplicationService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import com.github.shiyajian.support.common.model.page.PageData;
import io.swagger.v3.oas.annotations.Operation;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.request.WordPageServerFacadeRequest;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.response.WordPageServerFacadeResponse;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.WordAggr;
import github.shiyajian.${rootArtifactId}.domain.model.query.WordQuery;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.covert.WordServerFacadeCovert;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.request.WordDetailServerFacadeRequest;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.response.WordDetailServerFacadeResponse;

@RestController
@Tag(name = "测试", description = "测试")
public class WordServerFacade {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private WordApplicationService wordApplicationService;

    @GetMapping("/api/server/word/page")
    @Operation(tags = "分页查询列表")
    public PageData<WordPageServerFacadeResponse> getPage(@Validated WordPageServerFacadeRequest request) {
        WordQuery query = WordServerFacadeCovert.toQuery(request);
        PageData<WordAggr> pageResult = wordRepository.findPage(query);
        return pageResult.mapping(WordServerFacadeCovert::ofPage);
    }

    @GetMapping("/api/server/word/detail")
    @Operation(tags = "查询详情")
    public WordDetailServerFacadeResponse getDetail(@Validated WordDetailServerFacadeRequest request) {
        WordAggr aggr = wordRepository.findOne(request.getId());
        return WordServerFacadeCovert.of(aggr);
    }
}
