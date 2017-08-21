package memory.leaks;

import java.net.Socket;
import java.util.Map;
import java.util.WeakHashMap;

public class SocketManager {

	private Map<Socket, User> m = new WeakHashMap<Socket, User>();

	public void setUser(Socket socket, User user) {
		m.put(socket, user);
	}

	public User getUser(Socket socket) {
		return m.get(socket);
	}

	public void removeUser(Socket socket) {
		m.remove(socket);
	}
}