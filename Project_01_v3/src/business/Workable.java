/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package business;

/**
 *
 * @author tungi
 */
public interface Workable<T, K> {
    public void addNew(T t);
    public void update(T t);
    public void showAll();
    public T searchById(K id);
}
