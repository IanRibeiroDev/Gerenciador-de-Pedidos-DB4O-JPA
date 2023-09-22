package daodb4o;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Query;

import modelo.Cliente;
import modelo.Pedido;
import modelo.Quentinha;

public class Util {
	private static ObjectContainer manager;

	public static ObjectContainer conectarBanco() {
		if (manager != null)
			return manager; // ja tem uma conexao

		// ---------------------------------------------------------------
		// configurar, criar e conectar banco local (na pasta do projeto
		// ---------------------------------------------------------------

		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
		config.common().messageLevel(0); // mensagens na tela 0(desliga),1,2,3...

		// habilitar cascata na altera��o, remo��o e leitura
		config.common().objectClass(Quentinha.class).cascadeOnDelete(false);
		config.common().objectClass(Quentinha.class).cascadeOnUpdate(true);
		config.common().objectClass(Quentinha.class).cascadeOnActivate(true);
		config.common().objectClass(Cliente.class).cascadeOnDelete(false);
		config.common().objectClass(Cliente.class).cascadeOnUpdate(true);
		config.common().objectClass(Cliente.class).cascadeOnActivate(true);
		config.common().objectClass(Pedido.class).cascadeOnDelete(false);
		config.common().objectClass(Pedido.class).cascadeOnUpdate(true);
		config.common().objectClass(Pedido.class).cascadeOnActivate(true);

		// conexao local
		manager = Db4oEmbedded.openFile(config, "banco.db4o");
		return manager;
	}

	public static void desconectar() {
		if (manager != null) {
			manager.close();
			manager = null;
		}
	}

	public static int gerarIdQuentinha() {
		if (manager.query(Quentinha.class).size() == 0)
			// classe nao registrada no banco
			return 1;

		Query q = manager.query();
		q.constrain(Quentinha.class);
		q.descend("id").orderDescending();
		List<Quentinha> resultados = q.execute();

		if (resultados.size() > 0) {
			Quentinha quentinha = resultados.get(0); // max
			return quentinha.getId() + 1;
		} else
			return 1; // nenhum objeto quentinha encontrado
	}

	public static int gerarIdPedido() {
		if (manager.query(Pedido.class).size() == 0)
			// classe nao registrada no banco
			return 1;

		Query q = manager.query();
		q.constrain(Pedido.class);
		q.descend("id").orderDescending();
		List<Pedido> resultados = q.execute();

		if (resultados.size() > 0) {
			Pedido pedido = resultados.get(0); // max
			return pedido.getId() + 1;
		} else
			return 1; // nenhum objeto pedido encontrado
	}

	public static int gerarIdCliente() {
		if (manager.query(Cliente.class).size() == 0)
			// classe nao registrada no banco
			return 1;

		Query q = manager.query();
		q.constrain(Cliente.class);
		q.descend("id").orderDescending();
		List<Cliente> resultados = q.execute();

		if (resultados.size() > 0) {
			Cliente cliente = resultados.get(0); // max
			return cliente.getId() + 1;
		} else
			return 1; // nenhum objeto cliente encontrado
	}
}
