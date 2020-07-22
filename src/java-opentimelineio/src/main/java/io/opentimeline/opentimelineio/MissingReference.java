package io.opentimeline.opentimelineio;

import io.opentimeline.opentime.TimeRange;

public class MissingReference extends MediaReference {

    protected MissingReference() {
    }

    public MissingReference(String name, TimeRange availableRange, AnyDictionary metadata) {
        this.initObject(name, availableRange, metadata);
    }

    public MissingReference(MissingReference.MissingReferenceBuilder missingReferenceBuilder) {
        this.initObject(
                missingReferenceBuilder.name,
                missingReferenceBuilder.availableRange,
                missingReferenceBuilder.metadata);
    }

    private void initObject(String name, TimeRange availableRange, AnyDictionary metadata) {
        this.className = this.getClass().getCanonicalName();
        if (availableRange != null) {
            this.initialize(name, TimeRange.timeRangeToArray(availableRange), metadata);
        } else {
            this.initialize(name, new double[]{}, metadata);
        }
    }

    private native void initialize(String name, double[] availableRange, AnyDictionary metadata);

    public static class MissingReferenceBuilder {
        private String name = "";
        private TimeRange availableRange = null;
        private AnyDictionary metadata = new AnyDictionary();

        public MissingReferenceBuilder() {
        }

        public MissingReference.MissingReferenceBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MissingReference.MissingReferenceBuilder setAvailableRange(TimeRange availableRange) {
            this.availableRange = availableRange;
            return this;
        }


        public MissingReference.MissingReferenceBuilder setMetadata(AnyDictionary metadata) {
            this.metadata = metadata;
            return this;
        }

        public MissingReference build() {
            return new MissingReference(this);
        }
    }

    public native boolean isMissingReference();

}