package daodb4o;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

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
}
