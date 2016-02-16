package org.elsysbg.ip.todo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.elsysbg.ip.todo.entities.Task;

public class TaskService {
	private long lastId = 0;
	private List<Task> tasks = Collections.synchronizedList(new LinkedList<Task>());
	
	private synchronized long getAndIncrementNextId() {
		return ++lastId;
	}
	
	public Task createTask(Task task) {
		task.setId(getAndIncrementNextId());
		tasks.add(task);
		return task;
	}
	
	public List<Task> getTasks() {
		return new ArrayList<Task>(tasks);
	}
	
	public Task getTask(long taskId) {
		for(Task task : tasks) {
			if(taskId == task.getId()) {
				return task;
			}
		}
		throw new IllegalArgumentException("No task with this id");
	}
	
	public Task updateTask(Task task) {
		final Task oldTask = getTask(task.getId());
		tasks.remove(oldTask);
		tasks.add(task);
		return task;
	}
	
	public void deleteTask(long taskId) {
		final Task oldTask = getTask(taskId);
		tasks.remove(oldTask);
	}
}
