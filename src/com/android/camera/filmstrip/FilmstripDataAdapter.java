/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.camera.filmstrip;

import android.content.Context;
import android.view.View;

/**
 * An interface which defines the interactions between the
 * {@link FilmstripImageData} and the
 * {@link com.android.camera.ui.FilmstripView}.
 */
public interface FilmstripDataAdapter {
    /**
     * An interface which defines the update reporter used to return to the
     * {@link FilmstripListener}.
     */
    public interface UpdateReporter {
        /** Checks if the data of dataID is removed. */
        public boolean isDataRemoved(int dataID);

        /** Checks if the data of dataID is updated. */
        public boolean isDataUpdated(int dataID);
    }

    /**
     * An interface which defines the listener for data events over
     * {@link FilmstripImageData}. Usually
     * {@link com.android.camera.ui.FilmstripView} itself.
     */
    public interface Listener {
        /**
         * Called when the whole data loading is done. There is not any
         * assumption on the previous data.
         */
        public void onDataLoaded();

        /**
         * Called some of the data are updated.
         *
         * @param reporter Use this reporter to know what happened.
         */
        public void onDataUpdated(UpdateReporter reporter);

        /**
         * Called when a new data is inserted.
         *
         * @param dataID The ID of the inserted data.
         * @param data The inserted data.
         */
        public void onDataInserted(int dataID, FilmstripImageData data);

        /**
         * Called when a data is removed.
         *
         * @param dataID The ID of the removed data.
         * @param data The data.
         */
        public void onDataRemoved(int dataID, FilmstripImageData data);
    }

    /** Returns the total number of image data. */
    public int getTotalNumber();

    /**
     * Returns the view to visually present the image data.
     *
     * @param context The {@link android.content.Context} to create the view.
     * @param dataID The ID of the image data to be presented.
     * @return The view representing the image data. Null if unavailable or
     *         the {@code dataID} is out of range.
     */
    public View getView(Context context, int dataID);

    /**
     * Returns the {@link FilmstripImageData} specified by the ID.
     *
     * @param dataID The ID of the {@link FilmstripImageData}.
     * @return The specified {@link FilmstripImageData}. Null if not available.
     */
    public FilmstripImageData getImageData(int dataID);

    /**
     * Suggests the data adapter the maximum possible size of the layout so
     * the {@link FilmstripDataAdapter} can optimize the view returned for the
     * {@link FilmstripImageData}.
     *
     * @param widthPixels Maximum width in dp.
     * @param heightPixels Maximum height in dp.
     */
    public void suggestViewSizeBound(int widthPixels, int heightPixels);

    /**
     * Sets the listener for data events over the ImageData. Replaces the
     * previous listener if it exists.
     *
     * @param listener The listener to use.
     */
    public void setListener(Listener listener);

    /**
     * Returns whether the view of the data can be moved by swipe
     * gesture when in full-screen.
     *
     * @param dataID The ID of the data.
     * @return Whether the view can be moved.
     */
    public boolean canSwipeInFullScreen(int dataID);
}
