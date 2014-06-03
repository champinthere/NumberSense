package shrey.number.sense.gui;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import shrey.number.sense.*;

public class TrickCollection {

	private List<Trick> items;

	public TrickCollection() {
		items = new ArrayList<>();
	}

	public boolean add(String s) {
		if (!(s.indexOf('.') > -1));
			s = "shrey.number.sense." + s;
		Class<?> c = null;
		Object object = null;
		try {
			c = Class.forName(s);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Constructor<?> cons;
		try {
			cons = c.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return false;
		}

		try {
			object = cons.newInstance();
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
			return false;
		}
		
		if (object != null && Trick.class.isAssignableFrom(object.getClass()))  
			items.add((Trick) object);
		else
			return false;
		return true;
	}
	
	public Trick getRandomElement()  {
		return items.get((int) (Math.random() * items.size()));
	}
}
