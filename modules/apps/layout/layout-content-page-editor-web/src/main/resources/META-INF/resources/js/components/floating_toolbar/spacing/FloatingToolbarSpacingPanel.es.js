import 'clay-checkbox';
import Component from 'metal-component';
import Soy, {Config} from 'metal-soy';

import './FloatingToolbarSpacingPanelDelegateTemplate.soy';
import {CONFIG_KEYS, CONTAINER_TYPES, NUMBER_OF_COLUMNS_OPTIONS, PADDING_OPTIONS} from '../../../utils/sectionConstants';
import {updateSection} from '../../../utils/FragmentsEditorUpdateUtils.es';
import templates from './FloatingToolbarSpacingPanel.soy';
import {UPDATE_SECTION_COLUMNS_NUMBER, UPDATE_SECTION_CONFIG} from '../../../actions/actions.es';
import getConnectedComponent from '../../../store/ConnectedComponent.es';

/**
 * FloatingToolbarSpacingPanel
 */
class FloatingToolbarSpacingPanel extends Component {

	/**
	 * Handle container option change
	 * @param {Event} event
	 */
	_handleColumnSpacingOptionChange(event) {
		this._updateSectionConfig(
			{
				[CONFIG_KEYS.columnSpacing]: event.target.checked
			}
		);
	}

	/**
	 * Handle container spacing checkbox mousedown
	 * @param {Event} event
	 */
	_handleColumnSpacingOptionMousedown(event) {
		event.preventDefault();
	}

	/**
	 * Handle container option change
	 * @param {Event} event
	 */
	_handleContainerPaddingOptionChange(event) {
		const {delegateTarget} = event;
		const {paddingDirectionId} = delegateTarget.dataset;
		const {value} = delegateTarget;

		this._updateSectionConfig(
			{
				[CONFIG_KEYS[`padding${paddingDirectionId}`]]: value
			}
		);
	}

	/**
	 * Handle container option change
	 * @param {Event} event
	 */
	_handleContainerTypeOptionChange(event) {
		this._updateSectionConfig(
			{
				[CONFIG_KEYS.containerType]: event.delegateTarget.value
			}
		);
	}

	/**
	 * Handle number of columns option change
	 * @param {Event} event
	 */
	_handleNumberOfColumnsOptionChange(event) {
		const newValue = event.delegateTarget.value;
		const prevValue = this.item.columns.length;

		let updateSectionColumns = true;

		if (newValue < prevValue) {
			let columnsToRemove = this.item.columns.slice(newValue - prevValue);
			let showConfirmation;

			for (let i = 0; i < columnsToRemove.length; i++) {
				if (columnsToRemove[i].fragmentEntryLinkIds.length > 0) {
					showConfirmation = true;
					break;
				}
			}

			if (showConfirmation && !confirm(Liferay.Language.get('reducing-the-number-of-columns-will-lose-the-content-added-to-the-deleted-columns-are-you-sure-you-want-to-proceed'))) {
				event.preventDefault();
				event.delegateTarget.querySelector(`option[value="${prevValue}"]`).selected = true;
				updateSectionColumns = false;
			}
		}

		if (updateSectionColumns) {
			updateSection(
				this.store,
				UPDATE_SECTION_COLUMNS_NUMBER,
				{
					numberOfColumns: event.delegateTarget.value,
					sectionId: this.itemId
				}
			);
		}
	}

	/**
	 * Updates section configuration
	 * @param {object} config Section configuration
	 * @private
	 * @review
	 */
	_updateSectionConfig(config) {
		updateSection(
			this.store,
			UPDATE_SECTION_CONFIG,
			{
				config,
				sectionId: this.itemId
			}
		);
	}
}

/**
 * State definition.
 * @review
 * @static
 * @type {!Object}
 */
FloatingToolbarSpacingPanel.STATE = {

	/**
	 * @default CONTAINER_TYPES
	 * @memberOf FloatingToolbarSpacingPanel
	 * @private
	 * @review
	 * @type {object[]}
	 */
	_containerTypes: Config
		.array()
		.internal()
		.value(CONTAINER_TYPES),

	/**
	 * @default CONTAINER_TYPES
	 * @memberOf FloatingToolbarSpacingPanel
	 * @private
	 * @review
	 * @type {object[]}
	 */
	_numberOfColumnsOptions: Config
		.array()
		.internal()
		.value(NUMBER_OF_COLUMNS_OPTIONS),

	/**
	 * @default PADDING_OPTIONS
	 * @memberOf FloatingToolbarSpacingPanel
	 * @private
	 * @review
	 * @type {object[]}
	 */
	_paddingOptions: Config.array().internal().value(PADDING_OPTIONS),

	/**
	 * @default undefined
	 * @memberof FloatingToolbarSpacingPanel
	 * @review
	 * @type {!string}
	 */
	itemId: Config
		.string()
		.required(),

	/**
	 * @default undefined
	 * @memberof FloatingToolbarSpacingPanel
	 * @review
	 * @type {object}
	 */
	store: Config
		.object()
		.value(null)
};

const ConnectedFloatingToolbarSpacingPanel = getConnectedComponent(
	FloatingToolbarSpacingPanel,
	[
		'layoutData',
		'spritemap'
	]
);

Soy.register(ConnectedFloatingToolbarSpacingPanel, templates);

export {FloatingToolbarSpacingPanel};
export default FloatingToolbarSpacingPanel;