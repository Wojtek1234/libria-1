package controller;

import java.util.List;

/**
 * @author gore <a href="mailto:gore@gore-it.pl">
 * @since 1.0
 */
public interface ObjectsOwner<T>
{
     List<T> getObjects();
}
