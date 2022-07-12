package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.security.KeyStore.Entry;
import java.util.concurrent.CompletableFuture;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1"));

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill"));

  public static CompletableFuture<String> getCeoById(String ceo_id) throws Exception {
    Ceo test = new Ceo(ceo_id, null);
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    for (int i = 0; i < ceos.size(); i++) {
      if (ceos.get(i).getId() == test.getId()) {
        completableFuture.complete(ceos.get(i).toString());
        return completableFuture;
      }
    }
    completableFuture.complete("none");
    return completableFuture;
  }

  public static CompletableFuture<String> getEnterpriseByCeoId(String ceo_id) {
    Enterprise test = new Enterprise(null, null, ceo_id);
    CompletableFuture<String> completableFuture = new CompletableFuture<>();

    for (int i = 0; i < enterprises.size(); i++) {
      if (enterprises.get(i).getCeo_Id() == test.getCeo_Id()) {
        completableFuture.complete(enterprises.get(i).toString());
        return completableFuture;
      }
    }
    completableFuture.complete("none");
    return completableFuture;
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id)
      throws Exception {
    CompletableFuture<String> ceoById = getCeoById(ceo_id);
    CompletableFuture<String> entrepriseById = getEnterpriseByCeoId(ceo_id);

    String resultCeo = ceoById.get();
    System.out.println(resultCeo);

    String resultEntr = entrepriseById.get();
    System.out.println(resultEntr);

    Tuple2<String, String> test = Tuple.of(resultCeo, resultEntr);
    String s = test._1;
    System.out.println(s);

    return null;
  }
}
