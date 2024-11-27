package com.ninja.startup.marketplace.petblinders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.ninja.startup.marketplace.petblinders.entity.Carrinho;
import com.ninja.startup.marketplace.petblinders.entity.Item;
import com.ninja.startup.marketplace.petblinders.entity.Pedido;
import com.ninja.startup.marketplace.petblinders.entity.StatusPedido;
import com.ninja.startup.marketplace.petblinders.entity.Tag;
import com.ninja.startup.marketplace.petblinders.entity.Usuario;
import com.ninja.startup.marketplace.petblinders.repository.CarrinhoRepository;
import com.ninja.startup.marketplace.petblinders.repository.ItemRepository;
import com.ninja.startup.marketplace.petblinders.repository.PedidoRepository;
import com.ninja.startup.marketplace.petblinders.repository.TagRepository;
import com.ninja.startup.marketplace.petblinders.repository.UsuarioRepository;

@SpringBootApplication
@EnableMongoRepositories
public class PetblindersApplication implements CommandLineRunner {

	@Autowired
    private final UsuarioRepository usuarioRepository;

	@Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private TagRepository tagRepository;

    public PetblindersApplication(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

	List<Usuario> userList = new ArrayList<Usuario>();

    public static void main(String[] args) {
        SpringApplication.run(PetblindersApplication.class, args);
    }

    public void run(String... args) throws Exception {
		createData();
    }

	void createData() {
		System.out.println("Data creation started...");

        // Criando tags
        Tag tag1 = new Tag("1", "Eletrônicos");
        Tag tag2 = new Tag("2", "Roupas");
        tagRepository.save(tag1);
        tagRepository.save(tag2);

        // // Criando itens
        Item item1 = new Item("1", "Smartphone", 1999.99, 10, "Smartphone de última geração", List.of(tag1));
        Item item2 = new Item("2", "Camiseta", 59.99, 50, "Camiseta confortável", List.of(tag1, tag2));
        itemRepository.save(item1);
        itemRepository.save(item2);

        // // Criando carrinhos
        Carrinho carrinho1 = new Carrinho("1", 1999.99, List.of(item1, item2));
        Carrinho carrinho2 = new Carrinho("2", 59.99, List.of(item2));
        carrinhoRepository.save(carrinho1);
        carrinhoRepository.save(carrinho2);

		// // Criando usuários
		Usuario usuario1 = new Usuario("1", "Fernando", "fernando@unifei.edu.br", "fernando123", "35 9 9876-4321", false, List.of());
		Usuario usuario2 = new Usuario("2", "César", "cesar@unifei.edu.br", "cesar123", "(35) 998765432", false, List.of());
		usuarioRepository.save(usuario1);
    	usuarioRepository.save(usuario2);
		
        // // Criando pedidos
        Pedido pedido1 = new Pedido("1", StatusPedido.PROCESSANDO, 10.0, 2009.99, usuario1, LocalDateTime.now(), LocalDateTime.now());
        Pedido pedido2 = new Pedido("2", StatusPedido.PAGO, 5.0, 64.99, usuario2, LocalDateTime.now(), LocalDateTime.now());
        pedidoRepository.save(pedido1);
        pedidoRepository.save(pedido2);
		
		usuario1.setPedidos(List.of(pedido1, pedido2));
		usuario2.setPedidos(List.of(pedido2));
		usuarioRepository.save(usuario1);
    	usuarioRepository.save(usuario2);

		System.out.println("Data creation complete...");
	}
}
