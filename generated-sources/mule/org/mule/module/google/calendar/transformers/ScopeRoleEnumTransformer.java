
package org.mule.module.google.calendar.transformers;

import javax.annotation.Generated;
import org.mule.api.transformer.DiscoverableTransformer;
import org.mule.api.transformer.TransformerException;
import org.mule.module.google.calendar.ScopeRole;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

@Generated(value = "Mule DevKit Version 3.5.0-SNAPSHOT", date = "2014-04-16T09:46:10-05:00", comments = "Build master.1915.dd1962d")
public class ScopeRoleEnumTransformer
    extends AbstractTransformer
    implements DiscoverableTransformer
{

    private int weighting = DiscoverableTransformer.DEFAULT_PRIORITY_WEIGHTING;

    public ScopeRoleEnumTransformer() {
        registerSourceType(DataTypeFactory.create(String.class));
        setReturnClass(ScopeRole.class);
        setName("ScopeRoleEnumTransformer");
    }

    protected Object doTransform(Object src, String encoding)
        throws TransformerException
    {
        ScopeRole result = null;
        result = Enum.valueOf(ScopeRole.class, ((String) src));
        return result;
    }

    public int getPriorityWeighting() {
        return weighting;
    }

    public void setPriorityWeighting(int weighting) {
        this.weighting = weighting;
    }

}
