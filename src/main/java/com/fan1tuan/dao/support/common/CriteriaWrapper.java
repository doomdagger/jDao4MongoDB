package com.fan1tuan.dao.support.common;

import org.springframework.data.mongodb.core.geo.Circle;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * wrap the criteria object
 * @author Li He
 */
public class CriteriaWrapper {
	private Criteria criteria;
	private boolean isBootstrap;

	private CriteriaWrapper() {
		criteria = null;
		isBootstrap = false;
	}

	public static CriteriaWrapper instance() {
		return new CriteriaWrapper();
	}

	public CriteriaWrapper is(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).is(object);
		} else {
			criteria = where(field).is(object);
			isBootstrap = true;
		}
		return this;
	}

	public CriteriaWrapper all(String field, Collection<?> object) {
        if (isBootstrap) {
            criteria.and(field).all(object);
        } else {
            criteria = where(field).all(object);
            isBootstrap = true;
        }
		return this;
	}

	public CriteriaWrapper all(String field, Object... object) {
		if (isBootstrap) {
			criteria.and(field).all(object);
		} else {
			criteria = where(field).all(object);
			isBootstrap = true;
		}
		return this;
	}

    /**
     * new added operator, deal with condition when query a document has array property
     * @param field field of a document
     * @param criteriaWrapper normal criteria wrapper class
     * @return criteriaWrapper class for chaining invocation
     */
    public CriteriaWrapper elemMatch(String field, CriteriaWrapper criteriaWrapper) {
        if(isBootstrap) {
            criteria.and(field).elemMatch(criteriaWrapper.getCriteria());
        }else {
            criteria = where(field).elemMatch(criteriaWrapper.getCriteria());
            isBootstrap = true;
        }
        return this;
    }


	public CriteriaWrapper exists(String field, boolean object) {
		if (isBootstrap) {
			criteria.and(field).exists(object);
		} else {
			criteria = where(field).exists(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper gt(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).gt(object);
		} else {
			criteria = where(field).gt(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper gte(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).gte(object);
		} else {
			criteria = where(field).gte(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper in(String field, Collection<?> object) {
		if (isBootstrap) {
			criteria.and(field).in(object);
		} else {
			criteria = where(field).in(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper in(String field, Object... object) {
		if (isBootstrap) {
			criteria.and(field).in(object);
		} else {
			criteria = where(field).in(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper lt(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).lt(object);
		} else {
			criteria = where(field).lt(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper lte(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).lte(object);
		} else {
			criteria = where(field).lte(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper mod(String field, Number object, Number reminder) {
		if (isBootstrap) {
			criteria.and(field).mod(object, reminder);
		} else {
			criteria = where(field).mod(object, reminder);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper ne(String field, Object object) {
		if (isBootstrap) {
			criteria.and(field).ne(object);
		} else {
			criteria = where(field).ne(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper nin(String field, Collection<?> object) {
		if (isBootstrap) {
			criteria.and(field).nin(object);
		} else {
			criteria = where(field).nin(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper nin(String field, Object... object) {
		if (isBootstrap) {
			criteria.and(field).nin(object);
		} else {
			criteria = where(field).nin(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper not(String field) {
		if (isBootstrap) {
			criteria.and(field).not();
		} else {
			criteria = where(field).not();
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper regex(String field, Pattern object) {
		if (isBootstrap) {
			criteria.and(field).regex(object);
		} else {
			criteria = where(field).regex(object);
			isBootstrap = true;
		}

		return this;
	}

	public CriteriaWrapper regex(String field, String object) {
		if (isBootstrap) {
			criteria.and(field).regex(object);
		} else {
			criteria = where(field).regex(object);
			isBootstrap = true;
		}

		return this;
	}

    public CriteriaWrapper regex(String field, String object, String options) {
        if (isBootstrap) {
            criteria.and(field).regex(object,options);
        } else {
            criteria = where(field).regex(object,options);
            isBootstrap = true;
        }

        return this;
    }

	public CriteriaWrapper size(String field, int object) {
		if (isBootstrap) {
			criteria.and(field).size(object);
		} else {
			criteria = where(field).size(object);
			isBootstrap = true;
		}

		return this;
	}

	/*
	 * Type Number Double 1 String 2 Object 3 Array 4 Binary data 5 Undefined
	 * (deprecated) 6 Object id 7 Boolean 8 Date 9 Null 10 Regular Expression 11
	 * JavaScript 13 Symbol 14 JavaScript (with scope) 15 32-bit integer 16
	 * Timestamp 17 64-bit integer 18 Min key 255 Max key 127
	 */
	public CriteriaWrapper type(String field, int object) {
		if (isBootstrap) {
			criteria.and(field).type(object);
		} else {
			criteria = where(field).type(object);
			isBootstrap = true;
		}

		return this;
	}

	// Creates a geospatical criterion
	public CriteriaWrapper near(String field, double x, double y) {
		if (isBootstrap) {
			criteria.and(field).near(new Point(x, y));
		} else {
			criteria = where(field).near(new Point(x, y));
			isBootstrap = true;
		}

		return this;
	}

	// Creates a geospatical criterion
	public CriteriaWrapper near(String field, Point point) {
		if (isBootstrap) {
			criteria.and(field).near(point);
		} else {
			criteria = where(field).near(point);
			isBootstrap = true;
		}

		return this;
	}

	// Creates a geospatical criterion
	public CriteriaWrapper nearSphere(String field, double x, double y) {
		if (isBootstrap) {
			criteria.and(field).nearSphere(new Point(x, y));
		} else {
			criteria = where(field).nearSphere(new Point(x, y));
			isBootstrap = true;
		}

		return this;
	}

	// Creates a geospatical criterion
	public CriteriaWrapper nearSphere(String field, Point point) {
		if (isBootstrap) {
			criteria.and(field).nearSphere(point);
		} else {
			criteria = where(field).nearSphere(point);
			isBootstrap = true;
		}

		return this;
	}
	
	//use with nere
	public CriteriaWrapper maxDistance(String field, double object) {
		if (isBootstrap) {
			criteria.and(field).maxDistance(object);
		} else {
			criteria = where(field).maxDistance(object);
			isBootstrap = true;
		}

		return this;
	}
	
	public CriteriaWrapper withinSphere(String field, double centerX, double centerY, double radius) {
		if (isBootstrap) {
			criteria.and(field).withinSphere(new Circle(centerX, centerY, radius));
		} else {
			criteria = where(field).withinSphere(new Circle(centerX, centerY, radius));
			isBootstrap = true;
		}

		return this;
	}
	
	public CriteriaWrapper withinSphere(String field, Point center, double radius) {
		if (isBootstrap) {
			criteria.and(field).withinSphere(new Circle(center, radius));
		} else {
			criteria = where(field).withinSphere(new Circle(center, radius));
			isBootstrap = true;
		}

		return this;
	}
	
	public CriteriaWrapper withinSphere(String field, Circle circle) {
		if(circle != null)
		{
			if (isBootstrap) {
				criteria.and(field).withinSphere(circle);
			} else {
				criteria = where(field).withinSphere(circle);
				isBootstrap = true;
			}
		}

		return this;
	}

    /**
     * This method is deprecated, use static and(CriteriaWrapper ..wrappers) instead
     * @return criteria
     */
    @Deprecated
	public static CriteriaWrapper and(CriteriaWrapper one, CriteriaWrapper two){
		CriteriaWrapper wrapper = CriteriaWrapper.instance();
		wrapper.setCriteria(one.getCriteria().andOperator(two.getCriteria()));
		return wrapper;
	}

	public static CriteriaWrapper and(CriteriaWrapper ...wrappers){
        CriteriaWrapper wrapper = CriteriaWrapper.instance();

        Criteria criteria = new Criteria();
        List<Criteria> criteriaList = new ArrayList<>();
        for(CriteriaWrapper cw : wrappers){
            criteriaList.add(cw.getCriteria());
        }
        criteria.andOperator(criteriaList.toArray(new Criteria[0]));
        wrapper.setCriteria(criteria);

        return wrapper;
    }

    /**
     * This method id deprecated, use static nor(CriteriaWrapper ...wrappers) instead.
     * @return criteria
     */
    @Deprecated
	public static CriteriaWrapper nor(CriteriaWrapper one, CriteriaWrapper two){
		CriteriaWrapper wrapper = CriteriaWrapper.instance();
		wrapper.setCriteria(one.getCriteria().norOperator(two.getCriteria()));
		return wrapper;
	}

    public static CriteriaWrapper nor(CriteriaWrapper ...wrappers){
        CriteriaWrapper wrapper = CriteriaWrapper.instance();

        Criteria criteria = new Criteria();
        List<Criteria> criteriaList = new ArrayList<>();
        for(CriteriaWrapper cw : wrappers){
            criteriaList.add(cw.getCriteria());
        }
        criteria.norOperator(criteriaList.toArray(new Criteria[0]));
        wrapper.setCriteria(criteria);

        return wrapper;
    }

    /**
     * This method id deprecated, use static or(CriteriaWrapper ...wrappers) instead.
     * @return criteria
     */
    @Deprecated
	public static CriteriaWrapper or(CriteriaWrapper one, CriteriaWrapper two){
		CriteriaWrapper wrapper = CriteriaWrapper.instance();
		wrapper.setCriteria(one.getCriteria().orOperator(two.getCriteria()));
		return wrapper;
	}

    public static CriteriaWrapper or(CriteriaWrapper ...wrappers){
        CriteriaWrapper wrapper = CriteriaWrapper.instance();

        Criteria criteria = new Criteria();
        List<Criteria> criteriaList = new ArrayList<>();
        for(CriteriaWrapper cw : wrappers){
            criteriaList.add(cw.getCriteria());
        }
        criteria.orOperator(criteriaList.toArray(new Criteria[0]));
        wrapper.setCriteria(criteria);

        return wrapper;
    }

    /**
     * let you have access to the origin criteria object
     * @return Criteria Object
     */
	public Criteria getCriteria() {
		return this.criteria;
	}
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
		if(this.criteria!=null)
			this.isBootstrap = true;
	}

    /**
     * This method may cause null pointer exception.
     * use is(key, value) instead
     * @return criteria
     */
    @Deprecated
	public CriteriaWrapper and(String key,Object value)
	{
		this.criteria.and(key).is(value);
		return this;
	}
}
