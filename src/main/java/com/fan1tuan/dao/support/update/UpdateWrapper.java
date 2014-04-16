package com.fan1tuan.dao.support.update;

import org.springframework.data.mongodb.core.query.Update;

import java.util.Collection;

/**
 * Update Wrapper, wrapper update message
 * @author Li He
 */
public class UpdateWrapper {
	private Update update;
	
	private UpdateWrapper() {
		update = new Update();
	}

	
	public UpdateWrapper addToSet(String key, Object value){
		update.addToSet(key, value);
		return this;
	}
	
	public UpdateWrapper inc(String key, Number value){
		update.inc(key, value);
		return this;
	}
	
	// 0 for first, 1 for the last
	public UpdateWrapper pop(String key, int value){
		Update.Position position;
		if(value==0){
			position = Update.Position.FIRST;
		}else{
			position = Update.Position.LAST;
		}
		update.pop(key, position);
		return this;
	}
	
	public UpdateWrapper pull(String key, Object value){
		update.pull(key, value);
		return this;
	}
	
	public UpdateWrapper pullAll(String key, Collection<Object> value){
		update.pullAll(key, value.toArray(new Object[0]));
		return this;
	}
	public UpdateWrapper pullAll(String key, Object... value ){
		update.pullAll(key, value);
		return this;
	}
	
	public UpdateWrapper push(String key, Object value ){
		update.push(key, value);
		return this;
	}
	
	public UpdateWrapper pushAll(String key, Object... value ){
		update.pushAll(key, value);
		return this;
	}
	public UpdateWrapper pushAll(String key, Collection<Object> value ){
		update.pushAll(key, value.toArray(new Object[0]));
		return this;
	}
	
	public UpdateWrapper rename(String key, String value ){
		update.rename(key, value);
		return this;
	}

	public UpdateWrapper set(String key, Object value ){
		update.set(key, value);
		return this;
	}

    public UpdateWrapper setOnInsert(String key, Object value ){
        update.setOnInsert(key, value);
        return this;
    }

	public UpdateWrapper unset(String key){
		update.unset(key);
		return this;
	}
	
	public static UpdateWrapper instance(){
		UpdateWrapper updateWrapper = new UpdateWrapper();
		return updateWrapper;
	}

	
	public Update getUpdate(){
		return this.update;
	}
}
