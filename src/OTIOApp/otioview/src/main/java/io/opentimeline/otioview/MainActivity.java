package io.opentimeline.otioview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import io.opentimeline.opentime.RationalTime;
import io.opentimeline.opentime.TimeRange;
import io.opentimeline.opentimelineio.Clip;
import io.opentimeline.opentimelineio.ErrorStatus;
import io.opentimeline.opentimelineio.ExternalReference;
import io.opentimeline.opentimelineio.Stack;
import io.opentimeline.opentimelineio.Timeline;
import io.opentimeline.opentimelineio.Track;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Track track = new Track.TrackBuilder().build();
        Stack stack = new Stack.StackBuilder().build();
        RationalTime rt = new RationalTime(5, 24);
        ErrorStatus errorStatus = new ErrorStatus();
        stack.appendChild(track, errorStatus);
        Timeline timeline = new Timeline.TimelineBuilder().build();
        timeline.setTracks(stack);

        ExternalReference mr = new ExternalReference.ExternalReferenceBuilder()
                .setAvailableRange(TimeRange.rangeFromStartEndTime(
                        new RationalTime(5, 24),
                        new RationalTime(15, 24)))
                .setTargetURL("/var/tmp/test.mov")
                .build();
        Clip cl = new Clip.ClipBuilder()
                .setName("test clip1")
                .setMediaReference(mr)
                .setSourceRange(new TimeRange.TimeRangeBuilder().setDuration(rt).build())
                .build();
        Clip cl2 = new Clip.ClipBuilder()
                .setName("test clip2")
                .setMediaReference(mr)
                .setSourceRange(new TimeRange.TimeRangeBuilder().setDuration(rt).build())
                .build();
        Clip cl3 = new Clip.ClipBuilder()
                .setName("test clip3")
                .setMediaReference(mr)
                .setSourceRange(new TimeRange.TimeRangeBuilder().setDuration(rt).build())
                .build();
        track.appendChild(cl, errorStatus);
        track.appendChild(cl2, errorStatus);
        track.appendChild(cl3, errorStatus);

        TextView textView = findViewById(R.id.textView);
        textView.setText(timeline.toString());
    }
}
