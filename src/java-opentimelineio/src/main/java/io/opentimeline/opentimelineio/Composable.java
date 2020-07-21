package io.opentimeline.opentimelineio;

import io.opentimeline.opentime.RationalTime;

public class Composable extends SerializableObjectWithMetadata {

    protected Composable() {
    }

    public Composable(String name, AnyDictionary metadata) {
        this.initObject(name, metadata);
    }

    public Composable(String name) {
        this.initObject(name, new AnyDictionary());
    }

    public Composable(AnyDictionary metadata) {
        this.initObject("", metadata);
    }

    public Composable(Composable.ComposableBuilder builder) {
        this.initObject(builder.name, builder.metadata);
    }

    private void initObject(String name, AnyDictionary metadata) {
        this.className = this.getClass().getCanonicalName();
        this.initialize(name, metadata);
    }

    private native void initialize(String name, AnyDictionary metadata);

    public static class ComposableBuilder {
        private String name = "";
        private AnyDictionary metadata = new AnyDictionary();

        public ComposableBuilder() {
        }

        public Composable.ComposableBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public Composable.ComposableBuilder setMetadata(AnyDictionary metadata) {
            this.metadata = metadata;
            return this;
        }

        public Composable build() {
            return new Composable(this);
        }
    }

    public native boolean isVisible();

    public native boolean isOverlapping();

    public native Composition parent();

    public RationalTime getDuration(ErrorStatus errorStatus) {
        return RationalTime.rationalTimeFromArray(getDurationNative(errorStatus));
    }

    private native double[] getDurationNative(ErrorStatus errorStatus);
}
