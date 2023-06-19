package ${package};
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.request.WordPageServerFacadeRequest;
import github.shiyajian.${rootArtifactId}.domain.model.query.WordQuery;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.response.WordPageServerFacadeResponse;
import github.shiyajian.${rootArtifactId}.domain.model.aggr.WordAggr;
import github.shiyajian.${rootArtifactId}.facade.endpoint.server.word.response.WordDetailServerFacadeResponse;

public class WordServerFacadeCovert {

    public static WordQuery toQuery(WordPageServerFacadeRequest request) {
        WordQuery query = new WordQuery();
        return query;
    }

    public static WordPageServerFacadeResponse ofPage(WordAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WordPageServerFacadeResponse response = new WordPageServerFacadeResponse();
        return response;
    }

    public static WordDetailServerFacadeResponse of(WordAggr aggr) {
        if (aggr == null) {
            return null;
        }
        WordDetailServerFacadeResponse response = new WordDetailServerFacadeResponse();
        return response;
    }
}
