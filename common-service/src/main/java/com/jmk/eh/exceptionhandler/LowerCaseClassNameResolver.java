package com.jmk.eh.exceptionhandler;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.jmk.eh.apierror.ApiError;

public class LowerCaseClassNameResolver implements TypeIdResolver {
	
	private static final String APIERROR_PACKAGE = 
            ApiError.class.getPackage().getName();
	
	private JavaType mBaseType;

    @Override
    public void init(JavaType baseType)
    {
        mBaseType = baseType;
    }

    @Override
    public Id getMechanism()
    {
        return Id.CUSTOM;
    }

    @Override
    public String idFromValue(Object obj)
    {
        return idFromValueAndType(obj, obj.getClass());
    }

    @Override
    public String idFromBaseType()
    {
        return idFromValueAndType(null, mBaseType.getRawClass());
    }

    @Override
    public String idFromValueAndType(Object obj, Class<?> clazz)
    {
        String name = clazz.getName();
        if ( name.startsWith(APIERROR_PACKAGE) ) {
            return name.substring(APIERROR_PACKAGE.length() + 1);
        }
        throw new IllegalStateException("class " + clazz + " is not in the package " + APIERROR_PACKAGE);
    }

	@Override
	public JavaType typeFromId(DatabindContext context, String id) throws IOException {
		return TypeFactory.defaultInstance().constructSpecializedType(mBaseType, ApiError.class);

	}

	@Override
	public String getDescForKnownTypeIds() {
		// TODO Auto-generated method stub
		return null;
	}
}
