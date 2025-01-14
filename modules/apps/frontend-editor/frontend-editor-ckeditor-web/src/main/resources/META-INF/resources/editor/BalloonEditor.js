/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

import PropTypes from 'prop-types';
import React, {useState} from 'react';

import {Editor} from './Editor';

import '../css/main.scss';

const BalloonEditor = ({config = {}, contents, name, ...otherProps}) => {
	const defaultExtraPlugins = 'ballooneditor,videoembed';

	const [cssClass, setCssClass] = useState('');

	const extraPlugins = config.extraPlugins ? `${config.extraPlugins},` : '';

	const basicToolbars = {
		toolbarImage:
			'ImageAlignLeft,ImageAlignCenter,ImageAlignRight,LinkToolbar,AltImg',
		toolbarLink: 'LinkAddOrEdit,LinkRemove',
		toolbarTable: 'TableHeaders,TableRow,TableColumn,TableCell,TableDelete',
		toolbarText:
			'Styles,Bold,Italic,Underline,BulletedList,NumberedList,TextLink' +
			'JustifyLeft,JustifyCenter,JustifyRight,LineHeight,RemoveFormat',
		toolbarVideo: 'VideoAlignLeft,VideoAlignCenter,VideoAlignRight',
	};

	const editorConfig = {
		...basicToolbars,
		...config,
		extraAllowedContent: '*',
		extraPlugins: `${extraPlugins}${defaultExtraPlugins}`,
		title: false,
	};

	return (
		<Editor
			config={editorConfig}
			data={contents}
			name={name}
			onBeforeLoad={(CKEDITOR) => {
				CKEDITOR.ADDITIONAL_RESOURCE_PARAMS = {
					languageId: themeDisplay.getLanguageId(),
				};

				CKEDITOR.disableAutoInline = true;

				setCssClass(CKEDITOR.env.cssClass);

				CKEDITOR.env.cssClass = `${CKEDITOR.env.cssClass} lfr-balloon-editor lfr-tooltip-scope`;

				CKEDITOR.getNextZIndex = function () {
					return CKEDITOR.dialog._.currentZIndex
						? CKEDITOR.dialog._.currentZIndex + 10
						: Liferay.zIndex.WINDOW + 10;
				};
			}}
			onDestroy={() => {
				CKEDITOR.env.cssClass = cssClass;
			}}
			onInstanceReady={(event) => {
				const editor = event.editor;

				// Workaround to make the "CKEDITOR.ui.richCombo"
				// plugin work with the CKEditor (React) component
				// the "id" needs to be "cke_" + "editor.name"

				editor.element.setAttribute('id', `cke_${editor.name}`);

				const balloonToolbars = editor.balloonToolbars;

				balloonToolbars.create({
					buttons: editorConfig.toolbarText,
					cssSelector: '*',
				});

				balloonToolbars.create({
					buttons: editorConfig.toolbarImage,
					priority:
						window.CKEDITOR.plugins.balloontoolbar.PRIORITY.HIGH,
					widgets: 'image,image2',
				});

				balloonToolbars.create({
					buttons: editorConfig.toolbarLink,
					cssSelector: 'a',
					priority:
						window.CKEDITOR.plugins.balloontoolbar.PRIORITY.HIGH,
				});

				balloonToolbars.create({
					buttons: editorConfig.toolbarTable,
					priority:
						window.CKEDITOR.plugins.balloontoolbar.PRIORITY.HIGH,
					refresh(editor, path) {
						return (
							!!path.contains('table') ||
							!!path.contains('tbody') ||
							!!path.contains('tr') ||
							!!path.contains('td') ||
							path.lastElement.getName() === 'td'
						);
					},
				});

				balloonToolbars.create({
					buttons: editorConfig.toolbarVideo,
					priority:
						window.CKEDITOR.plugins.balloontoolbar.PRIORITY.HIGH,
					widgets: 'videoembed',
				});
			}}
			type="inline"
			{...otherProps}
		/>
	);
};

BalloonEditor.propTypes = {
	config: PropTypes.object,
	name: PropTypes.string,
};

export default BalloonEditor;
