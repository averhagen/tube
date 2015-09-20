package com.amverhagen.tube.systems;

import com.amverhagen.tube.components.Clickable;
import com.amverhagen.tube.components.DrawingDimension;
import com.amverhagen.tube.components.Position;
import com.artemis.Aspect;
import com.artemis.ComponentMapper;
import com.artemis.Entity;
import com.artemis.annotations.Wire;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

public class UiClickSystem extends com.artemis.systems.EntityProcessingSystem {
	@Wire
	ComponentMapper<DrawingDimension> dimensionWrapper;
	@Wire
	ComponentMapper<Position> positionWrapper;
	private Camera camera;
	private Vector3 unprojected;

	@SuppressWarnings("unchecked")
	public UiClickSystem(Camera camera) {
		super(Aspect.all(Clickable.class, DrawingDimension.class, Position.class));
		this.camera = camera;
		unprojected = new Vector3(0, 0, 0);
	}

	@Override
	protected void begin() {
		if (Gdx.input.justTouched()) {
			unprojected = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
		}
	}

	@Override
	protected void process(Entity e) {
		if (Gdx.input.justTouched()) {
			DrawingDimension drawComp = dimensionWrapper.get(e);
			Position pos = positionWrapper.get(e);
			if ((unprojected.x >= pos.x) && (unprojected.x <= (pos.x + drawComp.width)) && (unprojected.y >= pos.y)
					&& (unprojected.y <= (pos.y + drawComp.height))) {
				System.out.println("Touched");
			}
		}
	}
}