/*-
 * #%L
 * The Labkit image segmentation tool for Fiji.
 * %%
 * Copyright (C) 2017 - 2024 Matthias Arzt
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

package sc.fiji.labkit.ui;

import bdv.util.BdvHandle;
import org.scijava.plugin.SciJavaPlugin;
import sc.fiji.labkit.ui.models.ImageLabelingModel;
import sc.fiji.labkit.ui.models.SegmentationItem;

/**
 * Extension point for adding menu items and toolbar buttons to the Labkit
 * window from another jar. Annotate an implementation with
 * {@code @Plugin(type = LabkitExtension.class)}. Higher-priority extensions
 * run first.
 * <p>
 * {@link #extend} is called once for every Labkit window, on the Swing thread
 * that builds the window. An extension adds its items there, using
 * {@link Extensible#addMenuItem} with one of the {@link MenuBar} keys, and
 * {@link Extensible#addToolBarButton} for the toolbar. For the "Segmentation"
 * menu, use {@link SegmentationItem#SEGMENTER_MENU}: items added under
 * {@link MenuBar#SEGMENTER_MENU} are never shown.
 */
public interface LabkitExtension extends SciJavaPlugin {

	/**
	 * @param extensible where to add menu items and toolbar buttons
	 * @param model the image and the labeling shown in this window
	 * @param bdvHandle the BigDataViewer this window shows them in
	 */
	void extend(Extensible extensible, ImageLabelingModel model,
		BdvHandle bdvHandle);
}
