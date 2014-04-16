package com.fan1tuan.dao.support.aggregate;

import org.springframework.data.mongodb.core.aggregation.ExposedFields;
import org.springframework.data.mongodb.core.aggregation.Fields;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;

/**
 * Created by Li He on 2014/4/11.
 * Project Class for Aggregate operation.
 * 推荐使用 instance() 创建一个新的Project对象，不传任何参数
 * @author Li He
 */
public class Project {
    private ProjectionOperation projectionOperation;

    private Project(){
        projectionOperation = new ProjectionOperation();
    }

    private Project(String... fields){
        projectionOperation = new ProjectionOperation(Fields.fields(fields));
    }

    private Project(Fields fields){
        projectionOperation = new ProjectionOperation((fields));
    }

    /**
     * recommended way to create a new Project Object
     * @return Project Object
     */
    public static Project instance(){
        return new Project();
    }

    public static Project instance(String... fields){
        return new Project(fields);
    }

    public static Project instance(Fields fields){
        return new Project(fields);
    }

    public Project include(String... fields){
        projectionOperation.andInclude(fields);
        return this;
    }

    public Project exclude(String... fields){
        projectionOperation.andExclude(fields);
        return this;
    }

    public Project expression(String alias, String expression, Object... params){
        projectionOperation.andExpression(expression,params).as(alias);
        return this;
    }


    public AlgorithmBuilder and(String name){
        return new AlgorithmBuilder(this,projectionOperation.and(name));
    }

    public ExposedFields getFields(){
        return projectionOperation.getFields();
    }

    public ProjectionOperation getProjectionOperation() {
        return projectionOperation;
    }

    /**
     * inner class for algorithm on filed
     * @author  Li He
     */
    static class AlgorithmBuilder {
        private ProjectionOperation.ProjectionOperationBuilder builder;
        private Project parent;
        protected AlgorithmBuilder(Project parent, ProjectionOperation.ProjectionOperationBuilder builder) {
            this.builder = builder;
            this.parent = parent;
        }

        public Project as(String alias){
            return parent;
        }

        public AlgorithmBuilder divide(Number number){
            builder.divide(number);
            return this;
        }

        public AlgorithmBuilder divide(String fieldReference){
            builder.divide(fieldReference);
            return this;
        }

        public AlgorithmBuilder minus(Number number){
            builder.minus(number);
            return this;
        }

        public AlgorithmBuilder minus(String fieldReference){
            builder.minus(fieldReference);
            return this;
        }

        public AlgorithmBuilder mod(Number number){
            builder.mod(number);
            return this;
        }

        public AlgorithmBuilder mod(String fieldReference){
            builder.mod(fieldReference);
            return this;
        }

        public AlgorithmBuilder multiply(Number number){
            builder.multiply(number);
            return this;
        }

        public AlgorithmBuilder multiply(String fieldReference){
            builder.multiply(fieldReference);
            return this;
        }

        public AlgorithmBuilder plus(Number number){
            builder.plus(number);
            return this;
        }

        public AlgorithmBuilder plus(String fieldReference){
            builder.plus(fieldReference);
            return this;
        }

    }
}
