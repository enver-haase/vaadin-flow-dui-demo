import { LitElement, html, css, customElement } from 'lit-element';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/button/src/vaadin-button.js';
import '@vaadin/checkbox/src/vaadin-checkbox.js';

@customElement('designer-designed-view')
export class DesignerDesignedView extends LitElement {
  static get styles() {
    return css`
      :host {
          display: block;
          height: 100%;
      }
      `;
  }

  render() {
    return html`
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;">
 <vaadin-button>
   Button 
 </vaadin-button>
 <vaadin-button theme="tertiary" id="com.daimlertruck.buttonid" disabled>
  com.daimlertruck.fooview.foobutton
 </vaadin-button>
 <vaadin-checkbox type="checkbox" value="on">
   I agree 
 </vaadin-checkbox>
</vaadin-horizontal-layout>
`;
  }

  // Remove this method to render the contents of this view inside Shadow DOM
  createRenderRoot() {
    return this;
  }
}
