import java.util.LinkedList;

public class OrderTest {

  class OrderTest {
    private Order order;

    @BeforeEach
    void beforeEach()
    this.order = new Oder();

    //! Test Case 1
    @Test
    void testCreateOrder() {
      Assertions.assertEquals(0, this.order.getItems().size());
      Assertions.assertTrue(this.order.getItems() instanceof LinkedList());
    }

    @Test
    void testAss1() {
      Assertions.assertEquals(0, this.order.getItems().size());
      Order.Item apple = new Order.Item(3.5, 5);
      this.order.add(apple);
      Assertions.assertThat(this.order.getItems(), hasItem(apple));

    }

    @Test
    void testAss() {
      Assertions.assertEquals(0, this.order.getItems().size());
      Order.Item apple = new Order.Item(3.5, 5);
      this.order.add(apple);
      Assertions.assertThat(this.order.getItems(), hasItem(apple));

    }
  }
}
